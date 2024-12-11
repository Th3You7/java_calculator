import java.util.InputMismatchException;
import java.util.Scanner;



class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static double handleMismatchInput(Scanner scan) {
        double x = 0;
        boolean isValid = false;
        do {
            try {
                x = scan.nextDouble();
                isValid = true;
             } catch (InputMismatchException e) {
                System.out.println("==> Invalid value");
                scan.nextLine();
             }
        } while (!isValid);

        return x;
    }
   
    private static double[] getNumbers(Scanner scan) {
        // get the numbers
        double[] arr = new double[2];
        System.out.println("/*** Enter 1st number */");
        arr[0] = handleMismatchInput(scan);
        System.out.println("/*** Enter 2nd number */");
        arr[1] = handleMismatchInput(scan);
        return arr;
    }
    
    private static void sum(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res = arr[0] + arr[1];
        System.out.println(ANSI_GREEN + res + ANSI_RESET);
    }

    private static void minus(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res = arr[0] - arr[1];
        System.out.println(res);
    }

    private static void multiply(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res = arr[0] * arr[1];
        System.out.println(res);
    }

    private static void divide(Scanner scan) {
        double[] arr = getNumbers(scan);
        try {
            double res = arr[0] / arr[1];
        System.out.println(res);
        } catch (ArithmeticException e) {
            System.err.println("=> Error: " + e.getMessage());
        }
    }

    private static void power(Scanner scan) {
        double[] arr = getNumbers(scan);
        double res =  Math.pow(arr[0], arr[1]);
        System.out.println(res);
    }

    private static void squarRoot(Scanner scan) {
        double i;
        System.out.println("/*** Enter a number */");
        i = handleMismatchInput(scan);
        if(i < 0){
            System.err.println(ANSI_RED + "Error" + ANSI_RESET);
            return;
        }

        double res = Math.sqrt(i);
        System.out.println(res);

    }
    
    

    public static void main(String[] args) {
        // initial vars
         Scanner s = new Scanner(System.in);
         double choice;
         
         do {

            // Menu
             System.out.println("**************** Choose an operation ****************");
             System.out.println("/***** Menu *****/");
             System.out.println("1- ADD / 2- Minus / 3- Multiply / 4- Divide / 5- Power / 6- Square Root / 7- (EXIT: 0)");

             // get the operation
             System.out.println("/*** Select an operation */");
             choice = handleMismatchInput(s);

             // excute the operation
             switch((int)choice) {
                case 0:
                    System.out.println("*** GOODBYE!! ***");
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

                

                default:
                    System.out.println(ANSI_RED + "*** Invalid choice!! ***" + ANSI_RESET);
             }
         } while (choice != 0);

         s.close();
    }
}