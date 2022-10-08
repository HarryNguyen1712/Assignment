package Medium;


public class Data {
    void printData(int n) {
        synchronized (this) {// synchronized block
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        System.out.println("Value: " + n);

    }// end of the method
}

class MyThread1 extends Thread {
    Data t;

    MyThread1(Data t) {
        this.t = t;
    }

    public void run() {
        t.printData(5);
    }

}

class MyThread2 extends Thread {
    Data t;

    MyThread2(Data t) {
        this.t = t;
    }

    public void run() {
        t.printData(100);
    }
}
