package com.smarket.parallel;

import java.util.Map;


/**
 * @param <E>
 * @param <K>
 * @param <V>
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public interface ReduceCallback<E, K, V> {

    /**
     * Method description
     *
     * @param e
     * @param results
     */
    public void reduceDone(E e, Map<K,V> results);
}