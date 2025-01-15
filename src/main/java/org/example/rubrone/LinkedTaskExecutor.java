package org.example.rubrone;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedTaskExecutor {
    Queue<TaskTracker> tracker;
    ReentrantLock lock = new ReentrantLock();
    ReentrantLock failureLock = new ReentrantLock();

    Boolean failure = false;


    public void submit(Task task) {
        lock.lock();
        TaskTracker taskTracker = new TaskTracker(task, failure, failureLock);
        tracker.offer(taskTracker);
        lock.unlock();
    }






}
