import java.sql.*;
import java.util.Scanner;

public class CalculationBYPages_SK {

    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String user = "root";
        String password = "vilmas12";
        Scanner scanner = new Scanner(System.in);


        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

            System.out.println("Connected to database");

            System.out.println("How many pages a day do you want to read?");
            int pagesWant = scanner.nextInt();

            System.out.println("Max number of days you would like to finish reading a book?");
            int maxNumber = scanner.nextInt();

            String query = "SELECT * FROM finalbooks WHERE Pages BETWEEN 0 AND ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the input parameter for the prepared statement

            int pagesToSearch = maxNumber * pagesWant;
            System.out.println("We will try to find a book with max of " + pagesToSearch + " pages! ");

            pstmt.setInt(1, pagesToSearch);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Iterate through the result set and print the information
            while (rs.next()) {
                System.out.printf("BookID: %d Author: %s Region: %s Title: %s Pages: %d Published: %s \n",
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }

            } catch(SQLException e){
                e.printStackTrace();
            }

        }
}

