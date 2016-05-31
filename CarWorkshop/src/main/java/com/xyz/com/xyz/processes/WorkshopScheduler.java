package com.xyz.com.xyz.processes;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import com.xyz.model.CarTasks;

/**
 * Created by raj on 24/3/16.
 */
public class WorkshopScheduler {

    private enum PriorityStrategy {
        BY_FEE, BY_TIME;
    }

    private static String prioritizationStrategy;

    static ScheduledThreadPoolExecutor getScheduler() {
        return scheduler;
    }

    private static ScheduledThreadPoolExecutor scheduler;

    public static void initializeScheduler(Integer poolSize, String strategy) {
        scheduler = new ScheduledThreadPoolExecutor(poolSize);
        prioritizationStrategy = strategy;
    }

    private static List<CarTasks> sortTasksByFee(List<CarTasks> tasks) {
        Collections.sort(tasks, (thisTask, thatTask) -> thatTask.getServiceFee().compareTo(thisTask.getServiceFee()));
        return tasks;
    }

    private static List<CarTasks> sortTasksByTime(List<CarTasks> tasks) {
        Collections.sort(tasks, (thisTask, thatTask) -> thatTask.getTimeTaken().compareTo(thisTask.getTimeTaken()));
        return tasks;
    }

    public static List<CarTasks> getPrioritizedTasks(List<CarTasks> tasks) {
        if (PriorityStrategy.BY_TIME.name().equals(prioritizationStrategy)) {
            tasks = sortTasksByTime(tasks);
        } else {
            //Default to PriorityStrategy.BY_FEE
            tasks = sortTasksByFee(tasks);
        }
        return tasks;
    }
}
