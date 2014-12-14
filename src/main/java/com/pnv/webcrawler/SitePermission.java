package com.pnv.webcrawler;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class SitePermission {

    private static final SortedMap<String, Collection<String>> sitePermissions = new TreeMap<String, Collection<String>>();

    /**
     * Method description
     *
     * @param host
     * @param disallowedPaths
     */
	public static void put(String host, Collection<String> disallowedPaths) {
		sitePermissions.put(host, disallowedPaths);
	}


    /**
     * Method description
     *
     * @param host
     * @return
     */
	public static Collection<String> get(String host) {
		return sitePermissions.get(host);
	}


    /**
     * Method description
     *
     * @return
     */
    public static Object size()
    {
        return sitePermissions.size();
    }
}
