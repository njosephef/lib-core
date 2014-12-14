package com.pnv.webcrawler;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author ngvtien
 * @version $Revision:  $
 */
public class CrawlerUrl {
    private int depth = 0;
    private String urlString = null;
    private URL url = null;
    private boolean isAllowedToVisit;
    private boolean isCheckedForPermission = false;
    private boolean isVisited = false;

    /**
     * Constructor
     *
     * @param urlString
     * @param depth
     */
    public CrawlerUrl(String urlString, int depth) {
        this.depth = depth;
        this.urlString = urlString;
        computeURL();
    }

    private void computeURL() {
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            // something is wrong
        }
    }


    /**
     * Method description
     *
     * @return
     */
    public URL getURL() {
        return this.url;
    }


    /**
     * Method description
     *
     * @return
     */
    public int getDepth() {
        return this.depth;
    }


    /**
     * Method description
     *
     * @return
     */
    public boolean isAllowedToVisit() {
        return isAllowedToVisit;
    }


    /**
     * Method description
     *
     * @param isAllowedToVisit
     */
    public void setAllowedToVisit(boolean isAllowedToVisit) {
        this.isAllowedToVisit = isAllowedToVisit;
        this.isCheckedForPermission = true;
    }


    /**
     * Method description
     *
     * @return
     */
    public boolean isCheckedForPermission() {
        return isCheckedForPermission;
    }


    /**
     * Method description
     *
     * @return
     */
    public boolean isVisited() {
        return isVisited;
    }


    /**
     * Method description
     */
    public void setIsVisited() {
        this.isVisited = true;
    }


    /**
     * Method description
     *
     * @return
     */
    public String getUrlString() {
        return this.urlString;
    }


    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.urlString + " [depth=" + depth + " visit="
                + this.isAllowedToVisit + " check="
                + this.isCheckedForPermission + "]";
    }


    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.urlString.hashCode();
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

}
