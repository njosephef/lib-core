/*
 * DocumentFormatConverter.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.webcrawler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class DocumentFormatConverter
{
    private static DocumentFormatConverter converter = new DocumentFormatConverter();


    /**
     * Method description
     *
     * @return
     */
    public static DocumentFormatConverter getInstance()
    {
        return converter;
    }


    public DocumentFormatConverter()
    {

    }

    /**
     * Method description
     *
     * @param htmlContent
     * @return PlainContent
     * @throws IOException
     * @throws SAXException
     * @throws TikaException
     */
    public TEXTContent convert(HTMLContent htmlContent) throws IOException, SAXException,
        TikaException
    {
        InputStream is = new ByteArrayInputStream(htmlContent.getBody().getBytes());
        ContentHandler contenthandler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        Parser parser = new AutoDetectParser();
        parser.parse(is, contenthandler, metadata, new ParseContext());

        TEXTContent plainContent = new TEXTContent(htmlContent.getHeader(),
                                                     contenthandler.toString());
        return plainContent;
    }
}


/*
 * Changes:
 * $Log: $
 */