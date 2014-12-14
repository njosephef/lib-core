package com.pnv.hash;

import java.util.HashMap;


public class HashMapDemo {
   public static void main(String args[]) {
      // create hash map
      HashMap newmap = new HashMap();      
      
      // populate hash map
      newmap.put(1, "tutorials");
      newmap.put(2, "point");
      newmap.put(3, "is best");
      
      System.out.println("Values before remove: "+ newmap);
      
      // remove value for key 2
        String test = (String)newmap.remove(2);
        System.out.println("$$$$$$$$$$$$: " + test);
      System.out.println("Values after remove: "+ newmap);
   }    
}