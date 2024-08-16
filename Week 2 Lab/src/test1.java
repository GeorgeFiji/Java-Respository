import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class test1 {
    public static void main(String[] args) {
        // Queue Declaration
        Queue<Integer> calls = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        int menu_option = 0;
        int callID = 1; // This will be used to assign unique IDs to calls

        while (true) {
            System.out.println("\n1. \t Make a call");
            System.out.println("2. \t Answer a call");
            System.out.println("3. \t Exit");
            System.out.print("Choose an option: ");
            
            menu_option = in.nextInt();

            if (menu_option == 1) {
                // Make a call
                calls.add(callID);
                System.out.println("Caller " + callID + " has entered the queue.");
                callID++;
            } else if (menu_option == 2) {
                // Answer a call
                if (calls.isEmpty()) {
                    System.out.println("No calls in the queue.");
                } else {
                    int answeredCall = calls.poll();
                    System.out.println("Answering call from Caller " + answeredCall);
                }
            } else if (menu_option == 3) {
                // Exit
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }

            // Show the current queue length
            System.out.println("Current queue length: " + calls.size());
        }

        in.close();
    }
}
