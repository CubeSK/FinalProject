import java.sql.Connection;
import java.sql.DriverManager;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;



public class Main_LT {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws SQLException {

        boolean quit = false;
        int input = 0;

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "Jautajumsnr6663";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            printInstructions_LT.printInstructions();

            while (!quit) {

                try {
                    input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            // See all the books
                            readData_LT.readData(conn);
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
                            printInstructions_LT.printInstructions();
                            break;
                        case 5:
                            quit = true;
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

}


