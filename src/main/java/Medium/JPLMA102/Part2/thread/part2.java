package Medium.JPLMA102.Part2.thread;

import java.util.*;

class TaskList {
    static Map<String,String> assignedTaskList= new HashMap<>();
    static List<String> taskList= new ArrayList<>();

    public TaskList() {
    }

    public static List<String> getTaskList() {
        return taskList;
    }

    public static void setTaskList(List<String> taskList) {
        TaskList.taskList = taskList;
    }

    public static Map<String, String> getAssignedTaskList() {
        return assignedTaskList;
    }

    public static void setAssignedTaskList(Map<String, String> assignedTaskList) {
        TaskList.assignedTaskList = assignedTaskList;
    }

    public synchronized void addTask(String newTask){
        taskList.add(newTask);
    }

    public synchronized void assignTask(String employeeName,String task){
       taskList.remove(task);
       assignedTaskList.put(employeeName,task);
    }
}
class Manager extends Thread{
    static TaskList taskList = new TaskList();
    static String newTask;
    String threadName;
    private Thread t;

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
        try{
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("moi ban nhap task moi");
            newTask= sc.nextLine();
            taskList.addTask(newTask);
            System.out.println(" ban co muon nhap them khong(Y/N)");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("n")){
                break;
            }

        }
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
class Employee extends Thread{
    static TaskList taskList = new TaskList();
    String threadName;
    String employeeName;
    String taskName;
    private Thread t;

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
        System.out.println(taskList.toString());
        try{
        if(!TaskList.taskList.isEmpty()){
        taskList.assignTask(employeeName,taskName);
        }
        Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class part2 {
    public static void main(String[] args){

      Manager manager = new Manager("1");
      Employee employee1 = new Employee("Huy","2");
      Employee employee2 = new Employee("Anh","3");
      Employee employee3 = new Employee("Duy","4");

          if(!manager.isAlive()){

              manager.start();
              manager.setPriority(10);
          }


              employee1.start();
          employee2.start();
          employee3.start();



/*

            if(TaskList.getTaskList().isEmpty()){
                TaskList.assignedTaskList.forEach(((s, s2) -> System.out.println(s+"assigned"+s2)));

            }
*/









    }
}
