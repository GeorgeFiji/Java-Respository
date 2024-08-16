import java.util.ArrayList;

public class Fibonacci {

    public static void main(String[] args) {
        // Entry point of the program. Calls runFib method to execute Fibonacci calculations.
        runFib();
    }

    static void runFib() {
        // Variables for timing the execution
        long startTime, endTime, timeDifference;
        
        // Lists to store test values and results
        ArrayList<Integer> testValues = new ArrayList<>();
        ArrayList<Long> resultsRec = new ArrayList<>();
        ArrayList<Long> resultsIter = new ArrayList<>();
        ArrayList<Long> timesRec = new ArrayList<>();
        ArrayList<Long> timesIter = new ArrayList<>();

        // Add test values to the list
        int[] values = {5, 10, 15, 20, 30, 40, 50, 100, 500, 1000};
        for (int n : values) {
            testValues.add(n);
        }

        // Measure performance of recursive Fibonacci
        System.out.println("Recursive Fibonacci:");
        for (int n : testValues) {
            startTime = System.nanoTime(); // Start timing
            long resultRec = fibRec(n);   // Calculate Fibonacci number using recursion
            endTime = System.nanoTime();   // End timing
            timeDifference = endTime - startTime; // Calculate time taken

            resultsRec.add(resultRec);    // Store result
            timesRec.add(timeDifference); // Store time taken
            // Print result and time taken
            System.out.println("n = " + n + " Result: " + resultRec + " Time: " + timeDifference + " ns");
        }

        // Measure performance of iterative Fibonacci
        System.out.println("\nIterative Fibonacci:");
        for (int n : testValues) {
            startTime = System.nanoTime(); // Start timing
            long resultIter = fibIter(n); // Calculate Fibonacci number using iteration
            endTime = System.nanoTime();   // End timing
            timeDifference = endTime - startTime; // Calculate time taken

            resultsIter.add(resultIter);  // Store result
            timesIter.add(timeDifference); // Store time taken
            // Print result and time taken
            System.out.println("n = " + n + " Result: " + resultIter + " Time: " + timeDifference + " ns");
        }

        // Results and timings are now available in the ArrayLists for further analysis
    }

    // Recursive method to calculate Fibonacci number
    public static long fibRec(long n) {
        if (n == 0)
            return 0;  // Base case: fib(0) = 0
        else if (n == 1)
            return 1;  // Base case: fib(1) = 1
        else
            return fibRec(n - 1) + fibRec(n - 2); // Recursive case: fib(n) = fib(n-1) + fib(n-2)
    }

    // Iterative method to calculate Fibonacci number
    public static long fibIter(long n) {
        if (n == 0)
            return 0;  // Base case: fib(0) = 0
        else if (n == 1)
            return 1;  // Base case: fib(1) = 1

        // Initialize variables for iteration
        long fib = 1, prevFib = 0;
        for (int i = 2; i <= n; i++) {
            long temp = fib;
            fib += prevFib;   // Update fib to the next Fibonacci number
            prevFib = temp;   // Update prevFib to the previous Fibonacci number
        }
        return fib; // Return the computed Fibonacci number
    }
}
