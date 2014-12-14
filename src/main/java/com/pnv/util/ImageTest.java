/*
 * ImageTest.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ImageTest
{

    /**
     * Method description
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //        String str = "";

//        String str = "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";
        String str = "/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/wAARCAAQABADASIAAhEBAxEB/8QAFQABAQAAAAAAAAAAAAAAAAAACAn/xAAfEAADAQEBAQADAQEAAAAAAAAFBgcEAwgCAQkWEhP/xAAVAQEBAAAAAAAAAAAAAAAAAAAICf/EAB4RAAIDAQEAAwEAAAAAAAAAAAMEAQIFBgcREhMX/9oADAMBAAIRAxEAPwC5Eprk295VDk43dd+LlgeSxnXF/O7EyiRk5SJ5m+tf0o8MqUzGwac3VJlGZ8DM1sjZwKHeO7V9glXgHEhuHDoT6P7QjXglrJUqH5MEdY5FTWoR6H81Szuc2xWgTJLoBdbpK8YT+Of+MX7NPlocUMK9TSAyyTY3kF2xkMpuftXYVzPv4lZP9Uvs5ZN+htTQBi8yedZuMUXd/wAME0q6V/vVwTAPajnN+FRUncUO25AjirMhPkyfBof+SAEOeWzgg72PC/5jM/tD9TVRZ886DDlFrnfKO+2q1B+Pxqm8dklUoBh8pK1qogjvtTWGpfOJiYppPE5MZDLKUKchryyjkpczMP8APVNV4jxmCsaz3TMG8Xnyce0qZZoy2SLfo0VeeUKncx84mtKFxMXoNAWsTXpJLOzqfBagcXRe1wdPPV5kYvQv6tGZo3bUhipOMsEJz9NV+gQMUy/1qUA5u8RMaloAFOKfUM//2Q==";
        Base64 decoder = new Base64();
        //        jptools.util.Base64 decoder = jptools.util.Base64.getInstance();
        byte[] decodedBytes = decoder.decode(str);

        if (decodedBytes != null && decodedBytes.length > 0)
        {
            BufferedImage imag;
            try
            {
                String id = UUID.randomUUID().toString();

                System.out.println(decodedBytes.length);
                if (decodedBytes.length == 3013)
                {
                    System.out.println("=========================>>>>>>>>>>>>>>");
                }

                if (decodedBytes.length > 100)
                {
                    id = id + "_" + String.valueOf(decodedBytes.length);
                }

                System.out.println(id);

                //                ImageInputStream imageInput = ImageIO.createImageInputStream(input);

                imag = ImageIO.read(new ByteArrayInputStream(decodedBytes));
                if (imag != null)
                {
                    ImageIO.write(imag, "gif", new File("C:\\images\\" + id + ".gif"));
                }
            }
            catch (IOException e)
            {

            }
        }
    }

}


/*
 * Changes:
 * $Log: $
 */