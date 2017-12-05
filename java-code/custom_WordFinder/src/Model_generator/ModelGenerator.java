package Model_generator;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

public class ModelGenerator{
	
	//training data set needs to be 15, 000 for better result
	
	@SuppressWarnings("null")
	public static void TokenFinderModelGenerator() throws IOException {
		
		String onlpModelPath="C:/Users/NMatAli/Desktop/dependencies/model-file/en-sent-KYC.bin";
		String trainingDataFilePath="C:\\Users\\NMatAli\\Desktop\\dependencies\\training-files\\KYCDetails.train";
		
		Charset charset = Charset.forName("UTF-8");
		
		InputStreamFactory isf = new InputStreamFactory() {
			
			public InputStream createInputStream() throws IOException{
				
				return new FileInputStream(trainingDataFilePath);
				
			}
			
		};
		
		       ObjectStream<String> lineStream = new PlainTextByLineStream(isf, charset);
		       ObjectStream<NameSample> sampleStream = new NameSampleDataStream(lineStream);
		       TokenNameFinderModel model = null;
			   TokenNameFinderFactory nameFinderFactory = new TokenNameFinderFactory();
			   HashMap<String, Object> mp = new HashMap<String,Object>();
				
				try {
					
					model = NameFinderME.train("en", "KYC", sampleStream, TrainingParameters.defaultParams(),nameFinderFactory);
								
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
		
		String onlpModelPath="C:/Users/NMatAli/Desktop/dependencies/model-file/en-sent-KYC1.bin";
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
		
		
		
				
	}
}