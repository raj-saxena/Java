package com.xyz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xyz.com.xyz.processes.WorkshopScheduler;

/**
 * Created by raj on 24/3/16.
 */
public class Employee implements IEmployee, Runnable {
	private static final Logger logger = LogManager.getLogger(Employee.class);
	private final String name;
	private final String designation;

	public List<CarTasks> getTasks() {
		return tasks;
	}

	@Override
	public String toString() {
		return "Employee[" + "name='" + name + '\'' + ", designation='" + designation + '\'' + ']';
	}

	public void addTask(CarTasks task) {
		if (Objects.isNull(tasks)) {
			tasks = new ArrayList<>();
		}
		tasks.add(task);
	}

	private List<CarTasks> tasks;

	public Employee(String name, String designation) {
		this.name = name;
		this.designation = designation;
	}

	@Override
	public void run() {
		tasks = WorkshopScheduler.getPrioritizedTasks(tasks);
		tasks.forEach(task -> {
			logger.info(String.format("%s doing task => %s", this, task));
			try {
				//Sleep for task duration seconds.
				Thread.sleep(task.getTimeTaken() * 1000);
			} catch (InterruptedException e) {
				logger.error("interrupted", e);
			}
		});
	}
}
