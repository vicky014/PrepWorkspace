package com.practise.workshop;

public class TestCounters {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter safeCounter = new SynchronizedCounter();
        AsyncCounter unsafeCounter = new AsyncCounter();

        Runnable taskSafe = () -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        };

        Runnable taskUnsafe = () -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        };

        Thread t1 = new Thread(taskSafe);
        Thread t2 = new Thread(taskSafe);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Safe Counter: " + safeCounter.getValue()); // Always 2000

        Thread u1 = new Thread(taskUnsafe);
        Thread u2 = new Thread(taskUnsafe);
        u1.start();
        u2.start();
        u1.join();
        u2.join();
        System.out.println("Unsafe Counter: " + unsafeCounter.getValue()); // Often < 2000
    }
}

class SynchronizedCounter {
    private int count = 0;

    // Synchronized method → only one thread can execute at a time
    public synchronized void increment() {
        count++;
    }

    public synchronized int getValue() {
        return count;
    }
}

class AsyncCounter {
    private int count = 0;

    public void increment() {
        count++; // Not synchronized
    }

    public int getValue() {
        return count;
    }
}
