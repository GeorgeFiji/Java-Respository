public class Fibonacci {

    public static void main(String[] args) {
        runFib();
    }

    static void runFib() {
        long startTime, endTime, timeDifference;
        int[] testValues = {5, 10, 15, 20, 30, 40, 50, 100, 500, 1000};

        // Run and measure recursive Fibonacci
        System.out.println("Recursive Fibonacci:");
        for (int n : testValues) {
            startTime = System.nanoTime();
            long resultRec = fibRec(n);
            endTime = System.nanoTime();
            timeDifference = endTime - startTime;
            System.out.println("n = " + n + " Result: " + resultRec + " Time: " + timeDifference + " ns");
        }

        // Run and measure iterative Fibonacci
        System.out.println("\nIterative Fibonacci:");
        for (int n : testValues) {
            startTime = System.nanoTime();
            long resultIter = fibIter(n);
            endTime = System.nanoTime();
            timeDifference = endTime - startTime;
            System.out.println("n = " + n + " Result: " + resultIter + " Time: " + timeDifference + " ns");
        }
    }

    public static long fibRec(long n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibRec(n - 1) + fibRec(n - 2);
    }

    public static long fibIter(long n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        long fib = 1, prevFib = 0;
        for (int i = 2; i <= n; i++) {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}


