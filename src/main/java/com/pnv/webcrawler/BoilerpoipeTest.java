/*
 * BoilerpoipeTest.java
 *
 * Copyright by Orell F�ssli Wirtschaftsinformationen AG
 * Z�rich
 * All rights reserved.
 */
package com.pnv.webcrawler;

import java.net.MalformedURLException;
import java.net.URL;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.DefaultExtractor;


/**
 * @author ngvtien
 * @version $Revision:  $
 */
public class BoilerpoipeTest {

    /**
     * Method description
     *
     * @param args
     */
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://techcrunch.com/2014/05/26/on-the-set-of-hbos-silicon-valley/");
            System.out.println(url.toString());

        } catch (MalformedURLException e) {
            //            log.warn("Error occurred: " + e.getMessage(), e);
        }

        // This can also be done in one line:
        try {
            System.out.println(DefaultExtractor.INSTANCE.getText(url));
        } catch (BoilerpipeProcessingException e) {
            //            log.warn("Error occurred: " + e.getMessage(), e);
        }
    }

}


/*
 * Changes:
 * $Log: $
 */