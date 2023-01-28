import java.sql.*;
import java.util.Scanner;

public class FilterABookLH {
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT * FROM Finalbooks WHERE region = 'Europe'";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root", "Ebelmuiza1");;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.printf("BookID %d Author:  %s Region: %s Title: %s Pages: %d, Published: %d \n",
                    resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6));
        }

        conn.close();
    }
    public static String chooseRegion() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose a part of the world the author is from:");
            System.out.println("\t 1 - Europe");
            System.out.println("\t 2 - Asia");
            System.out.println("\t 3 - South America");
            System.out.println("\t 4 - North America");
            System.out.println("\t 5 - Not important");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    return "Europe";
                case 2:
                    return "Asia";
                case 3:
                    return "South America";
                case 4:
                    return "North America";
                case 5:
                    return "Not important";
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
    }
}
