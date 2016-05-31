package com.xyz.com.xyz.processes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xyz.model.CarTasks;
import com.xyz.model.Employee;

/**
 * This manager class schedules the tasks for employees. Created by raj on
 * 25/3/16.
 */
public class EmployeeTaskManager {
	private static final Logger logger = LogManager.getLogger(EmployeeTaskManager.class);

	/**
	 * Gets the employees, assigns tasks and schedules execution at
	 * 
	 * @param hourOfDay
	 */
	public static void start(Integer hourOfDay) {
		// Create and schedule tasks for every morning at hourOfDay O'clock
		Long delayInMinutes = 0L;//(getDelayTillInitialStart(hourOfDay)) / 60;
		List<Employee> employees = getEmployees();
		logger.info("Scheduling tasks for employees to run everyday,starting after =>" + delayInMinutes + " minutes. Employees => " + employees + "");
		employees.forEach(employee -> WorkshopScheduler.getScheduler().scheduleAtFixedRate(employee, delayInMinutes, 24 * 60, TimeUnit.MINUTES));
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee joe = new Employee("Joe", "Trainee");
		joe.addTask(CarTasks.WASH);
		joe.addTask(CarTasks.REPAIR);
		joe.addTask(CarTasks.PAINT);

		Employee smith = new Employee("Smith", "Expert");
		smith.addTask(CarTasks.REPAIR);

		Employee walker = new Employee("Walker", "Employee");
		walker.addTask(CarTasks.PAINT);
		walker.addTask(CarTasks.REPAIR);

		employees.add(joe);
		employees.add(smith);
		employees.add(walker);
		return employees;
	}

	private static Long getDelayTillInitialStart(Integer hourOfDay) {
		LocalDateTime localNow = LocalDateTime.now();
		ZoneId zoneId = ZoneId.of("America/Los_Angeles");
		ZonedDateTime zonedDateTimeNow = ZonedDateTime.of(localNow, zoneId);
		ZonedDateTime zonedNextAt9 = zonedDateTimeNow.withHour(hourOfDay).withMinute(0).withSecond(0);
		if (zonedDateTimeNow.compareTo(zonedNextAt9) > 0)
			zonedNextAt9 = zonedNextAt9.plusDays(1);
		return Duration.between(zonedDateTimeNow, zonedNextAt9).getSeconds();
	}
}
