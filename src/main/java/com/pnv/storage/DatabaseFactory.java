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
public class DatabaseFactory
{
    /** The BERKELEY_DB_ENV_HOME */
    private static final String BERKELEY_DB_ENV_HOME = "E:/envtools/BerkeleyDB/berkeleydb";

    private Environment dbEnv = null;
    
    private static DatabaseFactory instance = null;


    private DatabaseFactory() throws EnvironmentLockedException, DatabaseException
    {
        EnvironmentConfig envConf = new EnvironmentConfig();
        // environment will be created if not exists
        envConf.setAllowCreate(true);

        // open/create the DB environment using config
        dbEnv = new Environment(new File(BERKELEY_DB_ENV_HOME), envConf);
    }


    /**
     * Method description
     *
     * @return BerkeleyDBConfig
     * @throws DatabaseException 
     * @throws EnvironmentLockedException 
     */
    public static DatabaseFactory getInstance() throws EnvironmentLockedException,
        DatabaseException
    {
        if (instance == null)
        {
            instance = new DatabaseFactory();
        }
        return instance;
    }


    /**
     * Method description
     *
     * @throws DatabaseException
     */
    public void close() throws DatabaseException
    {
        dbEnv.close();
    }


    /**
     * Method description
     *
     * @param dbName
     * @return Database
     * @throws DatabaseException 
     */
    public Database create(String dbName) throws DatabaseException
    {
        DatabaseConfig dbConf = new DatabaseConfig();
        // db will be created if not exits
        dbConf.setAllowCreate(true);
        // create/open testDB using config
        Database db = dbEnv.openDatabase(null, dbName, dbConf);
        return db;
    }
}


/*
 * Changes:
 * $Log: $
 */