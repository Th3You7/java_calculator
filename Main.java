import java.util.Scanner;
import java.util.InputMismatchException;

class Main {

    private static int handleMismatchInput(Scanner scan) {
        int x = 0;
        boolean isValid = false;
        do {
            try {
                x = scan.nextInt();
                isValid = true;
             } catch (InputMismatchException e) {
                System.out.println("==> Invalid value");
                scan.nextLine();
             }
        } while (!isValid);

        return x;
    }
   
    
    private static void sum(int a, int b) {
        int res = a + b;

        System.out.println(res);
    }

    public static void main(String[] args) {
        // initial vars
         Scanner s = new Scanner(System.in);
         int choice, x, y;
         
         do {

            // Menu
             System.out.println("**************** Choose an operation ****************");
             System.out.println("/***** Menu *****/");
             System.out.println("1- ADD / 2- Minus / 3- Multiply / 4- Divide / (EXIT: 0)");

             // get the operation
             System.out.println("/*** Select an operation */");
             choice = handleMismatchInput(s);

             // get the numbers
             System.out.println("/*** Enter 1st number */");
             x = handleMismatchInput(s);
             System.out.println("/*** Enter 2nd number */");
             y = handleMismatchInput(s);
             
             

             // excute the operation
             switch (choice) {
                case 0:
                    System.out.println("*** GOODBYE!! ***");
                    break;

                case 1:
                    sum(x, y);
                    break;
             
                default:
                    System.out.println("*** Invalid choice!! ***");
             }
         } while (choice != 0);

         s.close();
    }
}