package com.pnv.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @author ngvtien
 * @version $Revision:  $
 */
public class ThreadLocalExample {

    /**
     * Method description
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // create a thread pool of 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);


        // Execute 10 tasks
        Future<?>[] f = new Future<?>[10];
        final java.util.Random r = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            f[i] = executor.submit(new Runnable() {
                public void run() {
                    System.out.println("My id is: " + UniqueThreadIdGenerator.getCurrentThreadId());

                    try {
                        Thread.sleep(r.nextInt(5000));
                    } catch (InterruptedException e) {
                    }
                }
            });
        }

        System.out.println("done submitting");

        // no more jobs
        executor.shutdown();

        // wait for work completion
        for (int i = 0; i < 10; i++) {
            try {
                f[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}