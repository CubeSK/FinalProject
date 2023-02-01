import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main_SK {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws SQLException {

        boolean quit = false;
        int input = 0;
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "vilmas12";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            System.out.println(ANSI_GREEN +"Welcome to your Library/Book Finder!" +ANSI_RESET);

            while (!quit) {
                printInstructions_LT.printInstructions();

                try {
                    input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {

                        case 1:
                            // See all the books
                            readData_LT.readData(conn);
                            break;
                        case 2:
                            AddBookClassSK.addBook(conn);
                            // Add a book
                            break;
                        case 3:
                            SelectABookSK.selectBook(conn);
                            // Select by criteria
                            break;
                        case 4:
                            quit = true;
                            break;
                        default:
                            System.out.println("Your input is not valid!");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Wrong input! Please use only numbers!");
                    scanner.nextLine();
                }

            }

        }
    }

}

