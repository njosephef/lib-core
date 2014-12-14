package com.pnv.webcrawler;

import java.io.InputStreamReader;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class CrawlingWorker {

    /**
     * Method description
     *
     * @param urlString
     * @return string
     */
    public static HTMLContent getContent(String urlString)
    {
        return getContent(new CrawlerUrl(urlString, 0));
    }


    /**
     * Method description
     *
     * @param url
     * @return string
     */
    public static HTMLContent getContent(CrawlerUrl url)
    {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url.getUrlString());
        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        String text = null;
        try {
            int statusCode = client.executeMethod(method);
            if (statusCode == HttpStatus.SC_OK) {
                text = StreamProcessing.readContentsFromStream(new InputStreamReader(method
                        .getResponseBodyAsStream(), method.getResponseCharSet()));
            }
        } catch (Throwable t) {
            System.out.println(t.toString());
            t.printStackTrace();
        } finally {
            method.releaseConnection();
        }
//        markUrlAsVisited(url);
        UrlWatcher.markUrlAsVisited(url);
        return new HTMLContent(url.getUrlString(), text);

    }
}
