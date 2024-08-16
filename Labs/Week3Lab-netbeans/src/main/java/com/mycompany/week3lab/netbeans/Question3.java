package com.mycompany.week3lab.netbeans;

/**
 * Fibonacci calculation methods.
 * 
 */
public class Question3 {

    // Recursive Fibonacci method
    int fib(int n) {
        if (n <= 1) return n;
        else return fib(n - 1) + fib(n - 2);
    }

    // Dynamic programming Fibonacci method
    int fib2(int n) {
        if (n <= 1) return n;
        int[] f = new int[n + 1]; // Array to store Fibonacci numbers
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        Question3 q3 = new Question3();
        
        int n = 10; // Example value
        
        // Testing the recursive method
        System.out.println("Fibonacci number at position " + n + " (recursive): " + q3.fib(n));
        
        // Testing the dynamic programming method
        System.out.println("Fibonacci number at position " + n + " (DP): " + q3.fib2(n));
    }
}
