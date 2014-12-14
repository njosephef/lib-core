package com.pnv.hash;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class Node {
    private String domain;
    private String ip;
    private int port;


    /**
     * Constructor
     *
     * @param domain
     * @param ip
     * @param port
     */
    public Node(String domain, String ip, int port)
    {
        this.domain = domain;
        this.ip = ip;
        this.port = port;
    }


    /**
     * Method description
     *
     * @return
     */
    public String getDomain()
    {
        return domain;
    }


    /**
     * Method description
     *
     * @param domain
     */
    public void setDomain(String domain)
    {
        this.domain = domain;
    }


    /**
     * Method description
     *
     * @return
     */
    public String getIp()
    {
        return ip;
    }


    /**
     * Method description
     *
     * @param ip
     */
    public void setIp(String ip)
    {
        this.ip = ip;
    }


    /**
     * Method description
     *
     * @return
     */
    public int getPort()
    {
        return port;
    }


    /**
     * Method description
     *
     * @param port
     */
    public void setPort(int port)
    {
        this.port = port;
    }


    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return domain+":"+ ip+":"+ port;
    }


    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + port;
        return result;
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node)obj;
        if (domain == null)
        {
            if (other.domain != null)
                return false;
        }
        else if (!domain.equals(other.domain))
            return false;
        if (ip == null)
        {
            if (other.ip != null)
                return false;
        }
        else if (!ip.equals(other.ip))
            return false;
        if (port != other.port)
            return false;
        return true;
    }
}