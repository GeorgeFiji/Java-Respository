public class App {
    public static void main(String[] args) throws Exception {
        
       
        MyThread thread1 = new MyThread();
        MyRunnable runnable1 = new MyRunnable();

        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread2.start();
    }
}
