package com.pnv.hash;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class VirtualNode {
    private int replicaNumber;
    private Node parent;


    /**
     * Constructor
     *
     * @param parent
     * @param replicaNumber
     */
    public VirtualNode(Node parent, int replicaNumber)
    {
        this.replicaNumber = replicaNumber;
        this.parent = parent;
    }


    /**
     * Method description
     *
     * @param host
     * @return true or false
     */
    public boolean matches(String host)
    {
        return parent.toString().equalsIgnoreCase(host);
    }


    /**
     * Method description
     *
     * @return int
     */
    public int getReplicaNumber()
    {
        return replicaNumber;
    }


    /**
     * Method description
     *
     * @param replicaNumber
     */
    public void setReplicaNumber(int replicaNumber)
    {
        this.replicaNumber = replicaNumber;
    }


    /**
     * Method description
     *
     * @return PhysicalNode
     */
    public Node getParent()
    {
        return parent;
    }


    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return parent.toString().toLowerCase() + ":" + replicaNumber;
    }


    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        result = prime * result + replicaNumber;
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
        VirtualNode other = (VirtualNode)obj;
        if (parent == null)
        {
            if (other.parent != null)
                return false;
        }
        else if (!parent.equals(other.parent))
            return false;
        if (replicaNumber != other.replicaNumber)
            return false;
        return true;
    }
}