import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int input = 0;
        System.out.println("What do you want to do? Please choose the following: " +
                "\n 1. See all the books " +
                "\n 2. Add a book " +
                "\n 3. Select a book by criteria " +
                "\n 4. See the options again " +
                "\n 5. Exit the application");

        while (!quit) {

            try {
                input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        System.out.println("Test 1");
                        // See all the books
                        break;
                    case 2:
                        System.out.println("Test 2");
                        // Add a book
                        break;
                    case 3:
                        System.out.println("Test 3");
                        // Select by criteria
                        break;
                    case 4:
                        System.out.println("Test 4");
                        break;
                    case 5:
                        System.out.println("Test 5");
                        break;
                    default:
                        System.out.println("Your input is not valid!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Wrong input! Integers only!");
                scanner.nextLine();
            }

        }
    }

}
