package Main;

import java.io.IOException;
import java.util.List;

import Sentence_Detector.EntityDetector;
import Sentence_Detector.SentenceDetect;
import opennlp.tools.util.InvalidFormatException;

public class Main{
	

	public static void main(String[] args) {
		
		try {
			
			String[] sentences = SentenceDetect.sentenceDetect("A claim is scored high. If a vehicle age is lesser than 7 days.");
			String modelPathAge="C:/Users/NMatAli/Desktop/dependencies/model-file/en-ner-age.bin";
			String modelPathNumber="C:/Users/NMatAli/Desktop/dependencies/model-file/en-ner-number.bin";
			String[] entitiesNumber= EntityDetector.detectEntity(sentences[0], modelPathNumber);
			String[] entitiesAge = EntityDetector.detectEntity(sentences[0], modelPathAge);
			
			for(String s: entitiesNumber)
				   System.out.println(s);
			
			for(String s: entitiesAge)
				   System.out.println(s);
			
			
		} catch (InvalidFormatException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch(IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
}