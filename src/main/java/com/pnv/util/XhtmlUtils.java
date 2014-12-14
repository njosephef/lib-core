/*
 * HTMLUtils.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public final class XhtmlUtils
{
    /** The ERROR_OCCURRED */
    private static final String ERROR_OCCURRED = "Error occurred: ";
    private static final String BINARY_IMAGE_SIGNATURE_GIF = "data:image/gif;base64";
    private static final String BINARY_IMAGE_SIGNATURE_JPG = "data:image/jpg;base64";
    private static final String BINARY_IMAGE_SIGNATURE_PNG = "data:image/png;base64";

    private static final Logger log = Logger.getLogger(XhtmlUtils.class);
    
    /**
     * Method description
     *
     * @param xhtml
     * @return List<String>
     */
    public List<String> getBinaryImageResources(String xhtml)
    {
        List<String> imageResources = new ArrayList<String>();
        Pattern p = Pattern.compile("[<](/)?img[^>]*[>]");
        Matcher m = p.matcher(xhtml);
        while (m.find())
        {
            String imgTag = m.group();
            XPath xPath = XPathFactory.newInstance().newXPath();
            InputSource source = new InputSource(new StringReader(imgTag));

            String imgSource = null;
            try
            {
                imgSource = (String)xPath.evaluate("//@src", source, XPathConstants.STRING);

                if (imgSource.contains(BINARY_IMAGE_SIGNATURE_GIF)
                    || imgSource.contains(BINARY_IMAGE_SIGNATURE_JPG)
                    || imgSource.contains(BINARY_IMAGE_SIGNATURE_PNG))
                {
                    String imageData = imgSource.substring(imgSource.indexOf(",") + 1);
                    imageResources.add(imageData);
                }
            }
            catch (XPathExpressionException e)
            {
                log.warn(ERROR_OCCURRED + e.getMessage(), e);
            }
        }
        return imageResources;
    }


    /**
     * Method description
     *
     * @param xhtml
     * @return String
     */
    public String modifyXMLResource(String xhtml)
    {
        Document doc = convertStringToDocument(xhtml);

        NodeList list = doc.getElementsByTagName("img");
        for (int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);
            NamedNodeMap attr = node.getAttributes();

            /*Node nodeAttr = attr.getNamedItem("src");
            String imageId = UUID.randomUUID().toString();
            nodeAttr.setNodeValue("/td-web/imageController?imageId=" + imageId);
            */

            Node nodeAttr = attr.getNamedItem("src");
            if (nodeAttr.getNodeValue().contains("data:image/png;base64"))
            {
                Attr newAttr = doc.createAttribute("width");
                newAttr.setValue("300");
                attr.setNamedItem(newAttr);
            }
        }

        return convertDocumentToString(doc);
    }


    private Document convertStringToDocument(String strXml)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            StringReader strReader = new StringReader(strXml);
            InputSource is = new InputSource(strReader);
            Document doc = builder.parse(is);
            return doc;
        }
        catch (ParserConfigurationException e)
        {
            log.warn(ERROR_OCCURRED + e.getMessage(), e);
        }
        catch (SAXException e)
        {
            log.warn(ERROR_OCCURRED + e.getMessage(), e);
        }
        catch (IOException e)
        {
            log.warn(ERROR_OCCURRED + e.getMessage(), e);
        }
        return null;
    }


    private String convertDocumentToString(Document doc)
    {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try
        {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        }
        catch (TransformerConfigurationException e)
        {
            log.warn(ERROR_OCCURRED + e.getMessage(), e);
        }
        catch (TransformerException e)
        {
            log.warn(ERROR_OCCURRED + e.getMessage(), e);
        }
        return null;
    }


    private byte[] decodeImageResource(String resource, String imageId)
    {
        Base64 decoder = new Base64();
        byte[] decodedBytes = decoder.decode(resource);
        if (decodedBytes != null && decodedBytes.length > 0)
        {
            BufferedImage imag;
            try
            {
                String id = imageId;

                imag = ImageIO.read(new ByteArrayInputStream(decodedBytes));
                if (imag != null)
                {
                    ImageIO.write(imag, "gif", new File("C:\\images\\" + id + ".gif"));
                }
            }
            catch (IOException e)
            {
                log.warn("Error occurred: " + e.getMessage(), e);
            }
        }

        return decodedBytes;
    }
}


/*
 * Changes:
 * $Log: $
 */