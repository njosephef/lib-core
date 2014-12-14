/*
 * Test.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.storage;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentLockedException;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class Test
{

    /**
     * Method description
     *
     * @param args
     * @throws DatabaseException 
     * @throws EnvironmentLockedException 
     */
    public static void main(String[] args) throws EnvironmentLockedException, DatabaseException
    {
        DatabaseFactory config = DatabaseFactory.getInstance();
        Database db = config.create("");

        db.close();
        config.close();
    }

}


/*
 * Changes:
 * $Log: $
 */