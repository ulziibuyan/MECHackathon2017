package Model_generator;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenSampleStream;
import opennlp.tools.tokenize.TokenizerFactory;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;


public class ModelGenerator{
	
	//training data set needs to be 15, 000 for better result
	
	public static void TokenModelGenerator() throws InvalidFormatException, IOException{
		
		String onlpModelPath="C:/Users/NMatAli/Desktop/dependencies/model-file/en-token-ADR.bin";
		String trainingDataFilePath="C:\\Users\\NMatAli\\Desktop\\dependencies\\training-files\\ENT-ADR-TOKEN.train";
		
		
        Charset charset = Charset.forName("UTF-8");
		
		     InputStreamFactory isf = new InputStreamFactory() {
			
			     public InputStream createInputStream() throws IOException{
				
				       return new FileInputStream(trainingDataFilePath);
				
			     }
			
		};
		
		

		String lang_code = "";
		Dictionary dict = null;
		Pattern alpha_numeric_pattern = null;
		
		ObjectStream<String> lineStream = new PlainTextByLineStream(isf, charset);
	    ObjectStream<TokenSample> sampleStream = new TokenSampleStream(lineStream);
	    TokenizerModel model = null;
	    TokenizerFactory factory = new TokenizerFactory(lang_code, dict, true, alpha_numeric_pattern);
	    TrainingParameters params = TrainingParameters.defaultParams();
	    
	    try { 
	    	   model = TokenizerME.train(sampleStream, factory, params); 
	    } 
	    finally { 
	    	    sampleStream.close(); 
	    }
		   
	    BufferedOutputStream modelOut = null;
		
		try {
			
			modelOut = new BufferedOutputStream(new FileOutputStream(onlpModelPath));
			model.serialize(modelOut);
			
		} finally {
			
			if(modelOut!=null) {
				
				modelOut.close();
				
			}
		}
				
	}
	
	@SuppressWarnings("null")
	public static void TokenFinderModelGenerator() throws InvalidFormatException, IOException {
		
		String onlpModelPath="C:/Users/NMatAli/Desktop/dependencies/model-file/en-ner-number.bin";
		
		String trainingDataFilePath="C:\\Users\\NMatAli\\Desktop\\dependencies\\training-files\\number.train";
		
		Charset charset = Charset.forName("UTF-8");
		
		InputStreamFactory isf = new InputStreamFactory() {
			
			public InputStream createInputStream() throws IOException{
				
				return new FileInputStream(trainingDataFilePath);
				
			}
			
		};
		
		       String entityType = "number";
		       ObjectStream<String> lineStream = new PlainTextByLineStream(isf, charset);
		       ObjectStream<NameSample> sampleStream = new NameSampleDataStream(lineStream);
		       TokenNameFinderModel model = null;
			   TokenNameFinderFactory nameFinderFactory = new TokenNameFinderFactory();
			   //HashMap<String, Object> mp = new HashMap<String,Object>();

			   try {
					
					model = NameFinderME.train("pt", entityType, sampleStream, TrainingParameters.defaultParams(),nameFinderFactory);
								
				} finally {
					
					sampleStream.close();
					
				}
				BufferedOutputStream modelOut = null;
				
				try {
					
					modelOut = new BufferedOutputStream(new FileOutputStream(onlpModelPath));
					model.serialize(modelOut);
					
				} finally {
					
					if(modelOut!=null) {
						
						modelOut.close();
						
					}
				}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void SentenceModelGenerator() throws IOException{
		
		String onlpModelPath="C:/Users/NMatAli/Desktop/dependencies/model-file/pt-sent-KYC.bin";
		String trainingDataFilePath="C:\\Users\\NMatAli\\Desktop\\dependencies\\training-files\\KYCDetails.train";
		
		Charset charset = Charset.forName("UTF-8");
		
		InputStreamFactory isf = new InputStreamFactory() {
			
			public InputStream createInputStream() throws IOException{
				
				return new FileInputStream(trainingDataFilePath);
				
			}
			
		};
		
		ObjectStream<String> lineStream = new PlainTextByLineStream(isf, charset);
		ObjectStream<SentenceSample> sampleStream = new SentenceSampleStream(lineStream);
		SentenceModel model = null;
        		
		try {
		   
			model = SentenceDetectorME.train("en", sampleStream, true, null, TrainingParameters.defaultParams());
       
        } finally {
			
			sampleStream.close();
			
		}
		BufferedOutputStream modelOut = null;
		
		try {
			
			modelOut = new BufferedOutputStream(new FileOutputStream(onlpModelPath));
			model.serialize(modelOut);
			
		} finally {
			
			if(modelOut!=null) {
				
				modelOut.close();
				
			}
		}

		
	}
	
	
	public static void main(String[] args) throws IOException{
		

		
		SentenceModelGenerator();
		//TokenFinderModelGenerator();
		//TokenModelGenerator();
		
				
	}
}