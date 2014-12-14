package com.smarket.parallel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import com.pnv.webcrawler.CrawlingWorker;
import com.pnv.webcrawler.DocumentFormatConverter;
import com.pnv.webcrawler.HTMLContent;
import com.pnv.webcrawler.TEXTContent;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class MapReduce {

    /**
     * Method description
     *
     * @param args
     * @throws TikaException 
     * @throws SAXException 
     * @throws IOException 
     */
        public static void main(String[] args) throws IOException, SAXException, TikaException
    {
               
                // the problem:
               
                // from here (INPUT)
               
                // "file1.txt" => "foo foo bar cat dog dog"
                // "file2.txt" => "foo house cat cat dog"
                // "file3.txt" => "foo foo foo bird"

                // we want to go to here (OUTPUT)
               
                // "foo" => { "file1.txt" => 2, "file3.txt" => 3, "file2.txt" => 1 }
                // "bar" => { "file1.txt" => 1 }
                // "cat" => { "file2.txt" => 2, "file1.txt" => 1 }
                // "dog" => { "file2.txt" => 1, "file1.txt" => 2 }
                // "house" => { "file2.txt" => 1 }
                // "bird" => { "file3.txt" => 1 }
               
                // in plain English we want to
               
                // Given a set of files with contents
                // we want to index them by word
                // so I can return all files that contain a given word
                // together with the number of occurrences of that word
                // without any sorting
               
                ////////////
                // INPUT:
                ///////////

        HTMLContent content = CrawlingWorker.getContent("http://javarevisited.blogspot.sg/2012/03/10-object-oriented-design-principles.html");
        System.out.println(content.getHeader());

        DocumentFormatConverter documentFormatConverter = new DocumentFormatConverter();
        TEXTContent plainContent = documentFormatConverter.convert(content);
               
                Map<String, String> input = new HashMap<String, String>();
        //                input.put("file1.txt", "foo foo bar cat dog dog");
        input.put("file2.txt", "foo house cat cat dog");
        input.put("file3.txt", "foo foo foo bird");

//        input.put("file3.txt", plainContent.getBody());
               
                // APPROACH #3: Distributed MapReduce
                {
                        final Map<String, Map<String, Integer>> output = new HashMap<String, Map<String, Integer>>();
                       
                        // MAP:
                       
                        final List<MappedItem> mappedItems = new LinkedList<MappedItem>();
                       
                        final MapCallback<String, MappedItem> mapCallback = new MapCallback<String, MappedItem>() {
                                public synchronized void mapDone(String file, List<MappedItem> results) {
                                    mappedItems.addAll(results);
                                }
                        };
                       
                        List<Thread> mapCluster = new ArrayList<Thread>(input.size());
                       
                        Iterator<Map.Entry<String, String>> inputIter = input.entrySet().iterator();
                        while(inputIter.hasNext()) {
                            Map.Entry<String, String> entry = inputIter.next();
                            final String file = entry.getKey();
                            final String contents = entry.getValue();
                            
                            Thread t = new Thread(new Runnable() {
                                public void run() {
                                    map(file, contents, mapCallback);
                                }
                            });
                            mapCluster.add(t);
                            t.start();
                        }
                       
                        // wait for mapping phase to be over:
                        for(Thread t : mapCluster) {
                            try {
                                t.join();
                            } catch(InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                       
                        // GROUP:
                       
                        Map<String, List<String>> groupedItems = new HashMap<String, List<String>>();
                       
                        Iterator<MappedItem> mappedIter = mappedItems.iterator();
                        while(mappedIter.hasNext()) {
                            MappedItem item = mappedIter.next();
                            String word = item.getWord();
                            String file = item.getFile();
                            List<String> list = groupedItems.get(word);
                            if (list == null) {
                                list = new LinkedList<String>();
                                groupedItems.put(word, list);
                            }
                            list.add(file);
                        }
                       
                        // REDUCE:
                       
                        final ReduceCallback<String, String, Integer> reduceCallback = new ReduceCallback<String, String, Integer>() {
                            public synchronized void reduceDone(String k, Map<String, Integer> v) {
                                output.put(k, v);
                            }
                        };
                       
                        List<Thread> reduceCluster = new ArrayList<Thread>(groupedItems.size());
                       
                        Iterator<Map.Entry<String, List<String>>> groupedIter = groupedItems.entrySet().iterator();
                        while(groupedIter.hasNext()) {
                            Map.Entry<String, List<String>> entry = groupedIter.next();
                            final String word = entry.getKey();
                            final List<String> list = entry.getValue();
                               
                            Thread t = new Thread(new Runnable() {
                                public void run() {
                                    reduce(word, list, reduceCallback);
                                }
                            });
                            reduceCluster.add(t);
                            t.start();
                        }
                       
                        // wait for reducing phase to be over:
                        for(Thread t : reduceCluster) {
                            try {
                                t.join();
                            } catch(InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                       
                        System.out.println(output);
                }
        }
       

    /**
     * Method description
     *
     * @param file
     * @param contents
     * @param mappedItems
     */
    /*public static void map(String file, String contents, List<MappedItem> mappedItems) {
            String[] words = contents.trim().split("\\s+");
            for(String word: words) {
                    mappedItems.add(new MappedItem(word, file));
            }
    }*/
       

    /**
     * Method description
     *
     * @param word
     * @param list
     * @param output
     */
    /*public static void reduce(String word, List<String> list, Map<String, Map<String, Integer>> output) {
            Map<String, Integer> reducedList = new HashMap<String, Integer>();
            for(String file: list) {
                    Integer occurrences = reducedList.get(file);
                    if (occurrences == null) {
                            reducedList.put(file, 1);
                    } else {
                            reducedList.put(file, occurrences.intValue() + 1);
                    }
            }
            output.put(word, reducedList);
    }*/
       
        /*public static interface MapCallback<E, V> {
               
                public void mapDone(E key, List<V> values);
        }*/
       
    /**
     * Method description
     *
     * @param file
     * @param contents
     * @param callback
     */
        public static void map(String file, String contents, MapCallback<String, MappedItem> callback) {
                String[] words = contents.trim().split("\\s+");
                List<MappedItem> results = new ArrayList<MappedItem>(words.length);
                for(String word: words) {
                        results.add(new MappedItem(word, file));
                }
                callback.mapDone(file, results);
        }
       
        /*public static interface ReduceCallback<E, K, V> {
               
                public void reduceDone(E e, Map<K,V> results);
        }*/
       
    /**
     * Method description
     *
     * @param word
     * @param list
     * @param callback
     */
        public static void reduce(String word, List<String> list, ReduceCallback<String, String, Integer> callback) {
               
                Map<String, Integer> reducedList = new HashMap<String, Integer>();
                for(String file: list) {
                        Integer occurrences = reducedList.get(file);
                        if (occurrences == null) {
                                reducedList.put(file, 1);
                        } else {
                                reducedList.put(file, occurrences.intValue() + 1);
                        }
                }
                callback.reduceDone(word, reducedList);
        }
       
        private static class MappedItem {
               
                private final String word;
                private final String file;
               
                public MappedItem(String word, String file) {
                        this.word = word;
                        this.file = file;
                }

                public String getWord() {
                        return word;
                }

                public String getFile() {
                        return file;
                }
               
                @Override
                public String toString() {
                        return "[\"" + word + "\",\"" + file + "\"]";
                }
        }
}