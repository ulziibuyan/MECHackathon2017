package Main;

import java.io.IOException;
import Sentence_Detector.SentenceDetect;
import opennlp.tools.util.InvalidFormatException;

public class Main{
	

	public static void main(String[] args) {
		
		try {
			
			SentenceDetect.sentenceDetect("A claim is scored high. This is assuming that are many parties living in the same house as another.");
			
		} catch (InvalidFormatException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
}