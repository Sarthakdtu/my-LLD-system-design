package org.example.rubrone;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.locks.ReentrantLock;

public class TaskTracker {
    Task task;
    Boolean failure;

    ReentrantLock lock;

    public TaskTracker(Task task, Boolean failure, ReentrantLock lock) {
        this.task = task;
        this.failure = failure;
        this.lock = lock;

    }

    public void run(Task task) {
        try {
            (new Thread(() -> task.doWork())).start();
        }
        catch (Exception e) {
            lock.lock();
            failure = true;
            lock.unlock();
        }
        finally {

        }

    }

}
