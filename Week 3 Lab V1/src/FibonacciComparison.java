import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class FibonacciComparison {
    public static void main(String[] args) {
        List<Integer> testValues = Arrays.asList(5, 10, 15, 20, 30, 40, 50, 100, 500, 1000);
        StringBuilder iterativeData = new StringBuilder();
        StringBuilder recursiveData = new StringBuilder();

        System.out.println("Iterative Approach:");
        for (int n : testValues) {
            long startTime = System.nanoTime();
            long result = FibonacciIterative.fib(n);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            iterativeData.append(n).append(",").append(duration).append("\n");
            System.out.println("fib(" + n + ") = " + result + ", Time: " + duration + " ns");
        }

        System.out.println("\nRecursive Approach:");
        for (int n : testValues) {
            if (n > 40) {
                // Recursive approach is too slow for large n, skipping
                recursiveData.append(n).append(",").append("Skipped").append("\n");
                System.out.println("fib(" + n + ") = Skipped");
                continue;
            }
            long startTime = System.nanoTime();
            long result = FibonacciRecursive.fib(n);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            recursiveData.append(n).append(",").append(duration).append("\n");
            System.out.println("fib(" + n + ") = " + result + ", Time: " + duration + " ns");
        }

        // Write data to files
        try (FileWriter writer = new FileWriter("iterative_data.csv")) {
            writer.write(iterativeData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("recursive_data.csv")) {
            writer.write(recursiveData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
