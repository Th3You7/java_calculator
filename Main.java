import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        // initial vars
         int choice;
         Scanner s = new Scanner(System.in);
        
         do {
             System.out.println("Choose an operation");
             System.out.println("/***** Menu *****/");
             System.out.println("1- ADD / 2- Minus / 3- Multiply / 4- Divide / (EXIT: 0)");
             choice = s.nextInt();

             
             
             switch (choice) {
                case 0:
                    System.out.println("*** GOODBYE!! ***");
                    break;
             
                default:
                    System.out.println("*** Invalid choice!! ***");
             }
         } while (choice != 0);
    }
}