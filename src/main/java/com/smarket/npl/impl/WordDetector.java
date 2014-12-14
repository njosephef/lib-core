package com.smarket.npl.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

import com.smarket.npl.ITokenizer;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class WordDetector implements ITokenizer
{

    /**
     * @see com.smarket.npl.ITokenizer#tokenize()
     */
    public void tokenize() throws InvalidFormatException, IOException
    {
        InputStream is = new FileInputStream("E:/DBox/Dropbox/smarket/ttd/en-token.bin");
        TokenizerModel model = new TokenizerModel(is);
        Tokenizer tokenizer = new TokenizerME(model);
        String tokens[] = tokenizer.tokenize("Hi. How are you? This is Mike.");
        for (String a : tokens)
            System.out.println(a);
        is.close();
    }


    /**
     * @see com.smarket.npl.ITokenizer#tokenize(java.lang.String)
     */
    public void tokenize(String str) throws FileNotFoundException, InvalidFormatException, IOException
    {
        InputStream is = new FileInputStream("E:/DBox/Dropbox/smarket/ttd/en-token.bin");
        TokenizerModel model = new TokenizerModel(is);
        Tokenizer tokenizer = new TokenizerME(model);
        String tokens[] = tokenizer.tokenize(str);
        for (String a : tokens)
            System.out.println(a);
        is.close();
    }
}
