package com.smarket.parallel;

import java.util.List;


/**
 * @param <E>
 * @param <V>
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public interface MapCallback<E, V> {

    /**
     * Method description
     *
     * @param key
     * @param values
     */
    public void mapDone(E key, List<V> values);
}