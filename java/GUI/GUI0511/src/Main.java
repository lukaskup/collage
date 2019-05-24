import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(2);
        Thread producerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    buffer.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    buffer.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread timer = new Thread();
        timer.start();
        producerThread.start();
        consumerThread.start();
        timer.sleep(15000);
        System.out.println("Thread stopped");
        producerThread.stop();
        consumerThread.stop();
        timer.stop();
    }
    static class Buffer {
        private Queue<Integer> list;
        private int size;
        public Buffer(int size) {
            this.list = new LinkedList<>();
            this.size = size;
        }
        public void put() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (list.size() >= size) {
                        wait();
                    }
                    list.add(value);
                    System.out.println("Produced " + value);
                    value++;
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        public void get() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0) {
                        wait();
                    }
                    int value = list.poll();
                    System.out.println("Consume " + value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}