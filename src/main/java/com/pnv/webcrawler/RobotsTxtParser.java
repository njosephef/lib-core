package com.pnv.webcrawler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class RobotsTxtParser {
	
	private static final String USER_AGENT = "User-agent:";

    private static final String DISALLOW = "Disallow:";
    

    /**
     * Method description
     *
     * @param host
     * @return
     */
	public static Collection<String> parseRobotsTxtFileToGetDisallowedPaths(
            String host) {
        // read the robots.txt file
//        String robotFilePath = getContent("http://" + host + "/robots.txt");
        HTMLContent robotFilePath = CrawlingWorker.getContent("http://" + host + "/robots.txt");
        Collection<String> disallowedPaths = new ArrayList<String>();
        if (robotFilePath != null) {
            Pattern p = Pattern.compile(USER_AGENT);
            String[] permissionSets = p.split(robotFilePath.getBody());
            String permissionString = "";
            for (String permission : permissionSets) {
                if (permission.trim().startsWith("*")) {
                    permissionString = permission.substring(1);
                }
            }
            p = Pattern.compile(DISALLOW);
            String[] items = p.split(permissionString);
            for (String s : items) {
                disallowedPaths.add(s.trim());
                // System.out.println(s.trim());
            }
        }
        SitePermission.put(host, disallowedPaths);
        return disallowedPaths;
    }
}
