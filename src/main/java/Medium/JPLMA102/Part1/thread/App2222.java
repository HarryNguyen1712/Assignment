package Medium.JPLMA102.Part1.thread;

import java.util.ArrayList;
import java.util.List;

class Inventory
{
    static int qoh=500;
   static int ordered =0;

    synchronized void request(int order) {
         ordered += order;
         qoh = 500 - ordered;
         System.out.println("Quantity ordered: "+ order);
         System.out.println("Quantity on hand:"+ qoh);
         System.out.println("Total quantify taken away by way of order: "+ordered);


         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }


class OurThread extends Thread
{
    private Thread t;
    String threadName;
    static Inventory inventory=new Inventory();

    public OurThread( String threadName) {
        this.threadName = threadName;
    }

     public void run()
    {
        inventory.request((int)(Math.random()*100));
    }
    public void start() {
        System.out.println("Thread"+ threadName);
        if (t == null) {
            t   = new Thread(this, threadName);
            t.start();
        }
    }
}
public class App2222 {
    public static void main(String[] args){
        OurThread thread1 = new OurThread("1");
        OurThread thread2= new OurThread("2");
        List<Thread> threads= new ArrayList<>();
        threads.add(thread1);
        threads.add(thread2);
        for(Thread thread:threads){
            thread.start();
        }
    }
}
