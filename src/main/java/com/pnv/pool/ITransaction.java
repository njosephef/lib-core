package com.pnv.pool;
/*
 * ITransaction.java
 *
 * Copyright by Orell F�ssli Wirtschaftsinformationen AG
 * Z�rich
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