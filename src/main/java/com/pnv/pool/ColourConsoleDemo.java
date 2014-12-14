package com.pnv.pool;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ColourConsoleDemo {

    /**
     * Method description
     *
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        System.out.println("\033[0m BLACK");
        System.out.println("\033[31m RED");
        System.out.println("\033[32m GREEN");
        System.out.println("\033[33m YELLOW");
        System.out.println("\033[34m BLUE");
        System.out.println("\033[35m MAGENTA");
        System.out.println("\033[36m CYAN");
        System.out.println("\033[37m WHITE");

        System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
        System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");

    }   
}