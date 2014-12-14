package com.pnv.webcrawler;

import com.smarket.npl.impl.SentenceDetector;
import com.smarket.npl.impl.WordDetector;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ParseHTMLWithTika {
    /**
    * Method description
    *
    * @param args
    * @throws Exception
    */
    public static void main(String args[]) throws Exception
    {
        try
        {

            //         is = new FileInputStream("C:/Temp/java-x.html");
            // convert String into InputStream
            HTMLContent content = CrawlingWorker.getContent("http://queue.acm.org/detail.cfm?id=2663760");
            System.out.println(content.getHeader());

            DocumentFormatConverter documentFormatConverter = DocumentFormatConverter.getInstance();
            TEXTContent plainContent = documentFormatConverter.convert(content);

            //            System.out.println("============ " + plainContent.getBody());

            SentenceDetector sentenceDetector = new SentenceDetector();
            //            sentenceDetector.detectSentence(plainContent.getBody());

            WordDetector wordDetector = new WordDetector();
            wordDetector.tokenize(plainContent.getBody());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

        }
    }
}