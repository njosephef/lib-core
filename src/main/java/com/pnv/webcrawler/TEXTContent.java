/*
 * HTMLContent.java
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
public class TEXTContent
{
    private String header;
    private String body;


    /**
     * Constructor
     * @param header 
     * @param body 
     *
     */
    public TEXTContent(String header, String body)
    {
        this.header = header;
        this.body = body;
    }


    /**
     * Gets the header
     *
     * @return Returns the header
     */
    public String getHeader()
    {
        return header;
    }


    /**
     * Sets the header
     *
     * @param header The header to set
     */
    public void setHeader(String header)
    {
        this.header = header;
    }


    /**
     * Gets the body
     *
     * @return Returns the body
     */
    public String getBody()
    {
        return body;
    }


    /**
     * Sets the body
     *
     * @param body The body to set
     */
    public void setBody(String body)
    {
        this.body = body;
    }
}


/*
 * Changes:
 * $Log: $
 */