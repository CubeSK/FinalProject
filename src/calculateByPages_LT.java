import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calculateByPages_LT {

    public static void main(String[] args) {

        System.out.println("How many pages a day do you want to read?");
        Scanner scanner = new Scanner(System.in);
        String pagesWant = scanner.nextLine();

        System.out.println("Max number of days you would like to finish reading a book?");
        String maxNumber = scanner.nextLine();

        Pattern pattern = Pattern.compile("[0-9]{2}");
        Matcher matcher = pattern.matcher(pagesWant);
        Matcher matcher1 = pattern.matcher(maxNumber);


        boolean validPageNumber = (matcher.matches() && matcher1.matches());

        if (!validPageNumber) {
            System.out.println("Please enter only positive double digits numbers!");
        } else {

            // Establish a connection to the database
            String url = "jdbc:mysql://localhost:3306/java34";
            String username = "root";
            String password = "";
            try (Connection con = DriverManager.getConnection(url, username, password)) {

                // Set the input parameter for the prepared statement

                int pagesToSearch = Integer.parseInt(maxNumber) * Integer.parseInt(pagesWant);
                System.out.println("We will try to find a book with " + pagesToSearch + " pages! ");

                // Create a prepared statement
                String query = "SELECT * FROM Finalbooks WHERE Pages = ?";
                PreparedStatement pstmt = con.prepareStatement(query);

                pstmt.setInt(1, pagesToSearch);

                // Execute the query
                ResultSet rs = pstmt.executeQuery();



                // Iterate through the result set and print the information
                while (rs.next()) {
                    System.out.printf("BookID: %d Author: %s Region: %s Title: %s Pages: %d Published: %s \n",
                            rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



