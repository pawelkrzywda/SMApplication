package com.smapp.counter;

import org.springframework.stereotype.Component;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class RequestCounter {
    private final AtomicLong addInt = new AtomicLong();

    public long get() {
        return addInt.get();
    }

    public long add() {
        return addInt.incrementAndGet();
    }
}
