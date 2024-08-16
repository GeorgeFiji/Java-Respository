import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class AnzGpt {
    public static void main(String[] args) {
        
        // Queue Declaration
        Queue<Integer> calls = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int menuOption = 0;
        int size = 0;
        Integer phoneNumber;
        
        while(true) {
            displayMenu(size);
            menuOption = getMenuOption(in);
            
            switch (menuOption) {
                case 1:
                    phoneNumber = getPhoneNumber(in);
                    calls.add(phoneNumber);
                    size++;
                    System.out.println("Ringing.... by " + phoneNumber + ". You are on Hold");
                    break;
                case 2:
                    if (!calls.isEmpty()) {
                        phoneNumber = calls.remove();
                        size--;
                        System.out.println("Answered: " + phoneNumber);
                    } else {
                        System.out.println("No calls to answer.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    in.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void displayMenu(int size) {
        System.out.println("\nMenu:");
        System.out.println("1. \tMake a call");
        System.out.println("2. \tAnswer a call---Callers on Hold: " + size);
        System.out.println("3. \tExit");
    }
    
    private static int getMenuOption(Scanner in) {
        System.out.print("Choose an option: ");
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            in.next(); // Clear invalid input
            System.out.print("Choose an option: ");
        }
        return in.nextInt();
    }
    
    private static int getPhoneNumber(Scanner in) {
        System.out.print("Enter Phone Number: ");
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid phone number.");
            in.next(); // Clear invalid input
            System.out.print("Enter Phone Number: ");
        }
        return in.nextInt();
    }
}
