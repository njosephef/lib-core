package com.pnv.pool;

import java.util.concurrent.atomic.AtomicInteger;


class UniqueThreadIdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadLocalId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return counter.getAndIncrement();
                }
            };

    public static int getCurrentThreadId() {
        return threadLocalId.get();
    }
}