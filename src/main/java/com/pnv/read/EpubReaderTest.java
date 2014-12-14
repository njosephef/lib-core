/*
 * EpubReader.java
 *
 * Copyright by Orell F�ssli Wirtschaftsinformationen AG
 * Z�rich
 * All rights reserved.
 */
package com.pnv.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubReader;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import com.pnv.webcrawler.DocumentFormatConverter;
import com.pnv.webcrawler.HTMLContent;
import com.pnv.webcrawler.TEXTContent;
import com.smarket.npl.impl.SentenceDetector;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class EpubReaderTest
{
    /**
     * Method description
     *
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     * @throws TikaException 
     * @throws SAXException 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException,
        TikaException
    {
        DocumentFormatConverter documentFormatConverter = DocumentFormatConverter.getInstance();
        
        EpubReader epubReader = new EpubReader();
        Book book = epubReader.readEpub(new FileInputStream("E:/DBox/Dropbox/book/Data/NoSQL.Distilled.0321826620.epub"));

        // print the first title
        List<String> titles = book.getMetadata().getTitles();
        System.out.println("book title:" + (titles.isEmpty() ? "book has no title" : titles.get(0)));
        
        List<Resource> resources = book.getContents();
        /*for (Resource resource : resources)
        {
            System.out.println(resource.getId());
            String data = new String(resource.getData(), resource.getInputEncoding());

            HTMLContent content = new HTMLContent();
            content.setHeader("");
            content.setBody(data);

            TEXTContent plainContent = documentFormatConverter.convert(content);

            System.out.println(">>>> " + plainContent);
        }*/
        
        
        System.out.println(resources.get(15).getId());
        String data = new String(resources.get(15).getData(), resources.get(15).getInputEncoding());
        HTMLContent content = new HTMLContent();
        content.setHeader("");
        content.setBody(data);

        TEXTContent plainContent = documentFormatConverter.convert(content);

        //        System.out.println(">>>> " + plainContent.getBody());

        SentenceDetector sentenceDetector = new SentenceDetector();
        sentenceDetector.detectSentence(plainContent.getBody());
    }

}


/*
 * Changes:
 * $Log: $
 */