import java.util.InputMismatchException;
import java.util.Scanner;



class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
   

    // handle wrong inputs
    private static double handleMismatchInput(Scanner scan) {
        double x = 0;
        boolean isValid = false;
        do {
            try {
                x = scan.nextDouble();
                isValid = true;
             } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid value! Enter a number" + ANSI_RESET);
                scan.nextLine();
             }
        } while (!isValid);

        return x;
    }
   
    // get 2 numbers from user
    private static double[] getNumbers(Scanner scan) {
        // get the numbers
        double[] arr = new double[2];
        System.out.println("/*** Enter 1st number */");
        arr[0] = handleMismatchInput(scan);
        System.out.println("/*** Enter 2nd number */");
        arr[1] = handleMismatchInput(scan);
        return arr;
    }
    
    // sum funcs
    private static void sum(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res = arr[0] + arr[1];
        System.out.println(ANSI_GREEN + res + ANSI_RESET);
    }

    // minus funcs
    private static void minus(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res = arr[0] - arr[1];
        System.out.println(ANSI_GREEN + res + ANSI_RESET);
    }

    // mutliply funcs
    private static void multiply(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res = arr[0] * arr[1];
        System.out.println(ANSI_GREEN + res + ANSI_RESET);
    }

    // divide funcs
    private static void divide(Scanner scan) {
        double[] arr = getNumbers(scan);
        try {
            double res = arr[0] / arr[1];
        System.out.println(ANSI_GREEN + res + ANSI_RESET);
        } catch (ArithmeticException e) {
            // handle exception of divide by 0
            System.err.println("=> Error: " + e.getMessage());
        }
    }

    // power funcs
    private static void power(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res =  Math.pow(arr[0], arr[1]);
        System.out.println(ANSI_GREEN + res + ANSI_RESET);
    }

    // square root funcs
    private static void squarRoot(Scanner scan) {
        // square requires only one input
        double i;
        System.out.println("/*** Enter a number */");
        i = handleMismatchInput(scan);
        // handle square of negative numbers
        if(i < 0){
            System.err.println(ANSI_RED + "Error" + ANSI_RESET);
            return;
        }

        double res = Math.sqrt(i);
        System.out.println(ANSI_GREEN + res + ANSI_RESET);

    }
    
    private static void fact(Scanner scan) {
        // factoriel requires only one input
        double res = 1, i;
        System.out.println("/*** Enter a number */");
        i = handleMismatchInput(scan);
        System.out.println(i);
        // handle factoriel of negative numbers
        if(i < 0) {System.err.println(ANSI_RED + "Error" + ANSI_RESET); return;}
        // if user input 0, return 1
        if(i == 0){
            System.out.println(ANSI_GREEN + res + ANSI_RESET);
        } else {
            for (int j = 1; j <= i; j++) {
                res *= j;
            }
            System.out.println(ANSI_GREEN + res + ANSI_RESET);
        } 
       
    }

    public static void main(String[] args) {
        // initial vars
         Scanner s = new Scanner(System.in);
         double choice;
         
         do {

            // Menu
             System.out.println(ANSI_BLUE + "************************************* Choose an operation *************************************" + ANSI_RESET);
             System.out.println(ANSI_BLUE + "1- ADD / 2- Minus / 3- Multiply / 4- Divide / 5- Power / 6- Square Root / 7- Factoriel (EXIT: 0)" + ANSI_RESET);

             // get the operation
             choice = handleMismatchInput(s);

             // excute the operations
             switch((int)choice) {
                case 0:
                    System.out.println(ANSI_PURPLE + "*** GOODBYE!! ***" + ANSI_RESET);
                    break;

                case 1:
                    sum(s);
                    break;

                case 2:
                    minus(s);
                    break;

                case 3:
                    multiply(s);
                    break;

                case 4:
                    divide(s);
                    break;

                case 5: 
                    power(s);
                    break;
                
                case 6: 
                    squarRoot(s);
                    break;

                case 7:
                    fact(s);
                    break;
                
                default:
                    System.out.println(ANSI_RED + "*** Invalid choice!! ***" + ANSI_RESET);
             }
         } while (choice != 0);

         s.close();
    }
}