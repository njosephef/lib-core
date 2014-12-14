package com.smarket.npl.impl;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class TestVisitor {
    /**
     * Method description
     *
     * @param args
     */
	public static void main(String[] args) {
		SentenceDetector sentenceDetector;
		WordDetector wordDetector;
		try
        {
		    sentenceDetector = new SentenceDetector();
		    wordDetector = new WordDetector();
		    
            sentenceDetector.detectSentence("Hi. How are you? This is Mike.");
            wordDetector.tokenize("str");
        }
        catch (InvalidFormatException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}