package com.pnv.pool;
/*
 * ITransaction.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public interface ITransaction
{

    /**
     * Method description
     *
     */
    void beginTransaction();


    /**
     * Method description
     *
     */
    void commit();


    /**
     * Method description
     *
     */
    void close();
}


/*
 * Changes:
 * $Log: $
 */