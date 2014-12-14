package com.smarket.npl.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

import com.smarket.npl.ISentenceDetector;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class SentenceDetector implements ISentenceDetector
{
    private SentenceDetectorME sdetector;
    private FileInputStream is;


    /**
     * Constructor
     *
     * @throws InvalidFormatException
     * @throws IOException
     */
    public SentenceDetector() throws InvalidFormatException, IOException
    {
        // always start with a model, a model is learned from training data
        is = new FileInputStream("E:/DBox/Dropbox/smarket/ttd/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        sdetector = new SentenceDetectorME(model);
    }


    /**
     * @see com.smarket.npl.ISentenceDetector#detectSentence()
     */
    public void detectSentence() throws InvalidFormatException, IOException
    {
        String paragraph = "Hi. How are you? This is Mike.";
 
        String sentences[] = sdetector.sentDetect(paragraph);
 
        System.out.println(sentences[0]);
        System.out.println(sentences[1]);
        is.close();
    }


    /**
     * @see com.smarket.npl.ISentenceDetector#detectSentence(java.lang.String)
     */
    public void detectSentence(String string) throws FileNotFoundException, InvalidFormatException, IOException
    {
        /*InputStream is = new FileInputStream("E:/DBox/Dropbox/smarket/ttd/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sdetector = new SentenceDetectorME(model);*/
 
        String sentences[] = sdetector.sentDetect(string);
        
        for (String str : sentences)
        {
            System.out.println(str);
        }
        
        is.close();
    }


    /**
     * @see com.smarket.npl.ISentenceDetector#detectSentence(java.io.File)
     */
    public void detectSentence(File file) throws FileNotFoundException, InvalidFormatException, IOException
    {
        /*String sentences[] = sdetector.sentDetect(s);
        System.out.println(sentences[0]);
        System.out.println(sentences[1]);
        is.close();*/
    }

}
