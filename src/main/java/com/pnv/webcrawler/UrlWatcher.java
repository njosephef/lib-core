package com.pnv.webcrawler;

import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class UrlWatcher {
	
    private static final SortedMap<String, CrawlerUrl> visitedUrls = new TreeMap<String, CrawlerUrl>();


    //	private static UrlWatcher instance = null;
	
	/*public static UrlWatcher getInstance() {
		if (instance == null ) {
			return new UrlWatcher();
		}
		return instance;
	}
	
	private UrlWatcher() {
		
	}*/
	
    /**
     * Method description
     *
     * @param url
     */
	public static void markUrlAsVisited(CrawlerUrl url) {
        visitedUrls.put(url.getUrlString(), url);
        url.setIsVisited();
    }


    /**
     * Method description
     *
     * @return
     */
	public static int size() {
		// TODO Auto-generated method stub
		return visitedUrls.size();
	}


    /**
     * Method description
     *
     * @param urlString
     * @return
     */
	public static boolean containsKey(String urlString) {
		// TODO Auto-generated method stub
		return visitedUrls.containsKey(urlString);
	}
}
