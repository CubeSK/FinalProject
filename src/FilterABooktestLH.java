import java.sql.*;

public class FilterABooktestLH {
    public static void main(String[] args) throws SQLException{
            String sql = "SELECT * FROM Finalbooks WHERE region = 'Europe'";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root", "Ebelmuiza1");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.printf("%-20s %-50s %40d \n",
                        resultSet.getString(2),resultSet.getString(4),resultSet.getInt(5));
            }

            conn.close();
        }
    }

