class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread1: " + i);
            try {
                Thread.sleep(5000); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread1 interrupted.");
            }
        }
    }
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(() -> thread1.run());
        t1.start();
    }
}