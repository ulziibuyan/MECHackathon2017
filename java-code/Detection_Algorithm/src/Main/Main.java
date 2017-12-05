package Main;

import java.io.IOException;
import java.util.List;

import Sentence_Detector.EntityDetector;
import Sentence_Detector.SentenceDetect;
import opennlp.tools.util.InvalidFormatException;

public class Main{
	

	public static void main(String[] args) {
		
		try {
			
			//SentenceDetect.sentenceDetect("A claim is scored high. This is assuming that are many parties living in the same house as another.");
			String[] entities = EntityDetector.detectEntity("This is assuming that are many parties living in the same Road 70C.");
			for(String s: entities)
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