/*
 * Job.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.pool;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class Job implements Runnable
{

    private String color;


    /**
     * Constructor
     * @param color 
     */
    public Job(String color)
    {
        this.color = color;
    }


    /**
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        while (true)
        {
            System.out.println(this.color + Thread.currentThread().getId() + " :"
                               + Thread.currentThread().getName() + "$$ " + ContextService.get());

            sleep();

        }
    }


    private void sleep()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            // log.warn("Error occurred: " + e.getMessage(), e);
        }
    }
}


/*
 * Changes:
 * $Log: $
 */