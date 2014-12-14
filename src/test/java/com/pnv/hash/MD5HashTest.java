package com.pnv.hash;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MD5HashTest
{
    @Test
    public void hash()
    {
    	MD5Hash hash = new MD5Hash();
    	
        long h = hash.hash("1");
        System.out.println(h);
        long expected = (long) 3301589560.0;//3301589560;
        Assert.assertEquals(h, expected);
    }
}