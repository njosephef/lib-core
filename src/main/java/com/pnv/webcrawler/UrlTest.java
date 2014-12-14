/*
 * UrlTest.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.webcrawler;



/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class UrlTest
{

    /**
     * Method description
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //        HTMLContent text = CrawlingWorker.getContent("http://javarevisited.blogspot.sg/2012/03/10-object-oriented-design-principles.html");
        HTMLContent text = CrawlingWorker.getContent("http://javarevisited.blogspot.sg/2012/03/10-object-oriented-design-principles.html");
        //        System.out.println(text.getBody());

        TEXTContent textContent = new TEXTContent(text.getHeader(), text.getBody());
        System.out.println(textContent.getBody());
    }
}


/*
 * Changes:
 * $Log: $
 */