package com.cengizhan.java.testproject.leet.code.random.concurrency;

import java.util.concurrent.locks.*;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int current;
    private Lock lock;
    private Condition condition;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 == 0 && current % 5 != 0) {
                    printFizz.run();
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 5 == 0 && current % 3 != 0) {
                    printBuzz.run();
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 == 0 && current % 5 == 0) {
                    printFizzBuzz.run();
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 != 0 && current % 5 != 0) {
                    printNumber.accept(current);
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
