class MyClass implements Runnable {
    int sum;
    int start;
    int end;

    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }

    int getsum() {
        return this.sum;
    }

    MyClass(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MythreadsImplement {
    public static void main(String args[]) {
        MyClass t0 = new MyClass(1, 500);
        Thread thread0 = new Thread(t0);
        thread0.start();
        MyClass t1 = new MyClass(501, 1000);
        Thread thread1 = new Thread(t1);
        thread1.start();
        try {
            thread0.join(3000);
            thread1.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(t0.getsum() + t1.getsum());
    }
}
