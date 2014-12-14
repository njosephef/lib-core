/*
 * UrlStorage.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.storage;

import com.sleepycat.bind.tuple.StringBinding;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.OperationStatus;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class UrlStorage
{
    /**
     * Method description
     *
     * @param args
     */
    public static void main(String[] args)
    {
        DatabaseFactory databaseFactory;
        Database database;
        try
        {
            databaseFactory = DatabaseFactory.getInstance();
            database = databaseFactory.create("UrlStorage");

            DatabaseEntry key = new DatabaseEntry();
            DatabaseEntry data = new DatabaseEntry();

            StringBinding.stringToEntry("DRY (Don't repeat yourself)", key);
            StringBinding.stringToEntry("Only one thing is constant in software field and that is \"Change\", "
                                                + "So encapsulate the code you expect or suspect to be changed in future. "
                                                + "Benefit of this OOPS Design principle is that Its easy to test and maintain proper encapsulated code. "
                                                + "If you are coding in Java then follow principle of making variable and methods private by default "
                                                + "and increasing access step by step e.g. from private to protected and not public. "
                                                + "Several of design pattern in Java uses Encapsulation, "
                                                + "Factory design pattern is one example of Encapsulation which encapsulate object creation code "
                                                + "and provides flexibility to introduce new product later with no impact on existing code.",
                                        data);

            database.put(null, key, data);

            if ((database.get(null, key, data, null) == OperationStatus.SUCCESS))
            {

                // display key/value pair
                System.out.println("Key  :" + StringBinding.entryToString(key));
                System.out.println("Data :" + StringBinding.entryToString(data));

            }
            else
            {
                System.out.println("Couldn't find");
            }

            database.close();
            databaseFactory.close();
        }
        catch (EnvironmentLockedException e)
        {
            //            log.warn("Error occurred: " + e.getMessage(), e);
        }
        catch (DatabaseException e)
        {
            //            log.warn("Error occurred: " + e.getMessage(), e);
        }
    }
}


/*
 * Changes:
 * $Log: $
 */