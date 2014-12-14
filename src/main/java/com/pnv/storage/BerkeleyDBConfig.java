/*
 * BerkeleyDBConfig.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.storage;

import java.io.File;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class BerkeleyDBConfig
{
    /** The BERKELEY_DB_ENV_HOME */
    private static final String BERKELEY_DB_ENV_HOME = "E:/envtools/BerkeleyDB/berkeleydb";

    private Environment dbEnv;
    
    private Database db;

    private static BerkeleyDBConfig instance;


    private BerkeleyDBConfig() throws EnvironmentLockedException, DatabaseException
    {
        EnvironmentConfig envConf = new EnvironmentConfig();
        // environment will be created if not exists
        envConf.setAllowCreate(true);

        // open/create the DB environment using config
        dbEnv = new Environment(new File(BERKELEY_DB_ENV_HOME), envConf);

        DatabaseConfig dbConf = new DatabaseConfig();
        // db will be created if not exits
        dbConf.setAllowCreate(true);

        // create/open testDB using config
        db = dbEnv.openDatabase(null, "testDB", dbConf);
    }


    /**
     * Method description
     *
     * @return BerkeleyDBConfig
     * @throws DatabaseException 
     * @throws EnvironmentLockedException 
     */
    public static BerkeleyDBConfig getInstance() throws EnvironmentLockedException,
        DatabaseException
    {
        if (instance == null)
        {
            instance = new BerkeleyDBConfig();
        }
        return instance;
    }

    /**
     * Method description
     *
     * @return Database
     * @throws EnvironmentLockedException
     * @throws DatabaseException
     */
    public Database getDatabase() throws EnvironmentLockedException, DatabaseException
    {
        return db;
    }


    /**
     * Method description
     *
     * @throws DatabaseException
     */
    public void close() throws DatabaseException
    {
        dbEnv.close();
        db.close();
    }
}


/*
 * Changes:
 * $Log: $
 */