/*
 * JobDemo.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class JobDemo
{
    /**
     * Method description
     *
     * @param args
     */
    public static void main(String args[])
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Job("\033[31m RED"));
        executorService.execute(new Job("\033[32m GREEN"));
        executorService.execute(new Job("\033[34m BLUE"));
    }
}


/*
 * Changes:
 * $Log: $
 */