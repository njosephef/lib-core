package com.pnv.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class StreamProcessing {

    /**
     * Method description
     *
     * @param input
     * @return
     * @throws IOException
     */
	public static String readContentsFromStream(Reader input)
            throws IOException {

        BufferedReader bufferedReader = null;
        if (input instanceof BufferedReader) {
            bufferedReader = (BufferedReader) input;
        } else {
            bufferedReader = new BufferedReader(input);
        }

        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[4 * 1024];
        int charsRead;
        while ((charsRead = bufferedReader.read(buffer)) != -1) {
            sb.append(buffer, 0, charsRead);
        }
        return sb.toString();
    }
}
