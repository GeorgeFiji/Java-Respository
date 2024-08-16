import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Anzcalls {
    public static void main(String[] args) {
        
        // Queue Declaration
        Queue<Integer> calls = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int menu_option = 0;
        int size = 0;
        Integer phone_no = 0;
        
        while(true){
            System.out.println("1. \t Make a call");
            System.out.println("2. \t Answer a call---Callers on Hold: " + size);
            System.out.println("3. \t Exit");
            
            menu_option = in.nextInt();

            if (menu_option == 1) {
                System.out.println("Enter Phone Number: ");
                phone_no = in.nextInt();
                calls.add(phone_no);
                size++;
                System.out.println("Ringing.... by " + phone_no + ". You are on Hold");
            } else if(menu_option == 2) {
                if(!calls.isEmpty()){
                    phone_no = calls.remove();
                    size--;
                    System.out.println("Answered: " + phone_no);
                } else {
                    System.out.println("No calls to answer.");
                }
            } else if(menu_option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        in.close();
    }
}
