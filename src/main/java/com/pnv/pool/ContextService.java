/*
 * ContextService.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ContextService
{
    static final AtomicInteger NEXT_ID = new AtomicInteger();

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() 
    {
        @Override
        protected Integer initialValue()
        {
            Integer number = NEXT_ID.incrementAndGet();
            System.out.println(number);
            return number;
        }
    };


    /**
     * Gets the threadid
     *
     * @return Returns the threadid
     */
    public static Integer get()
    {
        return threadId.get();
    }
}


/*
 * Changes:
 * $Log: $
 */