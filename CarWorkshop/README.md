# Design a Task Executor for a Car Workshop.

The Car workshop has following Employees on the payroll:

#### Employee Name | Designation 
Joe | Trainee  
Smith | Expert  
Walker | Employee

Following tasks/duties are performed in the workshop:
#### Task Name | Service Fee($) |Time Taken(Hours)
Car-Wash | 100 |2  
Car-Repair | 1000 | 5  
Car-Paint | 1100 | 4  


On a given day, a schedule is created in the morning, in which task/tasks are assigned to each Employee as mentioned below:
#### Employee Name | Task Name | 
Joe | Car-Wash, Car-Repair, Car-Paint  
Smith | Car-Repair  
Walker | Car-Paint, Car-Repair

#### Program should :  
1. Design and implement Task, Employee and Schedule classes.  
2. Design and Implement Executor which will schedule and execute tasks of all employees.
3. All Employees will start their work in Parallel (multi-threaded).
4. There can be 2 strategies of Task Prioritization –
    * Tasks can be prioritized based on the time taken. More time consuming task should be executed prior to other lesser time-consuming tasks assigned to that employee. 
    * Tasks can be prioritized based on Service Fee. A Task which charges more service fee should be executed first.
