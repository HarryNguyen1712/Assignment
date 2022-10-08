package Medium.JPLMA102.Part2.thread;

import java.util.*;

class TaskList {
    static Map<String,String> assignedTaskList= new HashMap<>();
    static List<String> taskList= new ArrayList<>();

    public static List<String> getTaskList() {
        return taskList;
    }

    public static void setTaskList(List<String> taskList) {
        TaskList.taskList = taskList;
    }

    public synchronized void addTask(String newTask){
        taskList.add(newTask);
    }
    public synchronized void assignTask(String employeeName,String task){
       taskList.remove(task);
       assignedTaskList.put(employeeName,task);
    }
    public TaskList() {
    }
}
class Manager extends Thread{
    private Thread t;
    String threadName;
    static TaskList taskList = new TaskList();
    static String newTask;

    public Manager(String threadName) {
        this.threadName = threadName;
    }

    public static String getNewTask() {
        return newTask;
    }

    public static void setNewTask(String newTask) {
        Manager.newTask = newTask;
    }

    @Override
    public void start() {
        System.out.println("Thread"+ threadName);
        if (t == null) {
            t   = new Thread(this, threadName);
            t.start();
        }
    }

    @Override
    public void run() {
        Scanner sc= new Scanner(System.in);
        System.out.println("moi ban nhap task moi");
        newTask= sc.nextLine();
        taskList.addTask(newTask);
    }
}
class Employee extends Thread{
    private Thread t;
    String threadName;
    static TaskList taskList = new TaskList();
    String employeeName;
    String taskName;

    public Employee(String employeeName,String threadName) {
        this.threadName = threadName;
        this.employeeName=employeeName;
    }

    public void start() {
        System.out.println("Thread"+ threadName);
        if (t == null) {
            t   = new Thread(this, threadName);
            t.start();
        }
    }

    @Override
    public void run() {

        taskList.assignTask(employeeName,taskName);
    }
}
public class part2 {
    public static void main(String[] args){
      Manager manager = new Manager("1");
      Employee employee1 = new Employee("Huy","2");
      Employee employee2 = new Employee("Anh","3");
      Employee employee3 = new Employee("Duy","4");

      manager.start();
      manager.setPriority(1);


    }
}
