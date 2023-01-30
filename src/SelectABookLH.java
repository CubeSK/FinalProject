import java.sql.*;
import java.util.Scanner;

public class SelectABookLH {
    static String dbURL = "jdbc:mysql://localhost:3306/finalproject";
    static String user = "root";
    static String password = "Ebelmuiza1";


    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection(dbURL, user, password);
        //selectgenrefilter(conn);
        //selectregionfilter(conn);
        //selectpagefilter(conn);
        //selectyearfilter(conn);
        //

        //public static void selectgenrefilter(Connection conn) throws SQLException {
        System.out.println("What genre would you like to read? Please choose from the following: " +
                "\n 1 History " +
                "\n 2 Romance " +
                "\n 3 Parenting " +
                "\n 4 Politics " +
                "\n 5 Hobbies " +
                "\n 6 Not important");
        String genrefilter = null;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            genrefilter = "History";
        } else if (choice == 2) {
            genrefilter = "Romance";
        } else if (choice == 3) {
            genrefilter = "Parenting";
        } else if (choice == 4) {
            genrefilter = "Politics";
        } else if (choice == 5) {
            genrefilter = "Hobbies";
        } else if (choice == 6) {
            genrefilter = "History" + "Romance" + "Parenting" + "Politics" + "Hobbies";
        } else {
            System.out.println("Please enter number from 1 to 6");
        }

        //public void selectregionfilter(Connection conn) throws SQLException {
        System.out.println("Which region should the author come from? Please choose from the following: " +
                "\n 1 Europe " +
                "\n 2 Asia " +
                "\n 3 North America " +
                "\n 4 South America " +
                "\n 5 Not important");
        int choice1 = scanner.nextInt();
        String regionfilter = null;
        if (choice1 == 1) {
            regionfilter = "Europe";
        } else if (choice1 == 2) {
            regionfilter = "Asia";
        } else if (choice1 == 3) {
            regionfilter = "North America";
        } else if (choice1 == 4) {
            regionfilter = "South America";
        } else if (choice1 == 5) {
            regionfilter = "Europe" + "Asia" + "North America" + "South America";
        } else {
            System.out.println("Please enter number from 1 to 5!");
        }

        //public void selectpagefilter (Connection conn) throws SQLException {

        System.out.println("How many pages should the book have? Please choose from the following: " +
                "\n 1 less than or equal to 200" +
                "\n 2 more than 200" +
                "\n 3 Not important");
        int choice2 = scanner.nextInt();
        int pageMin = 0, pageMax = 0;
        if (choice2 == 1) {
            pageMin = 1;
            pageMax = 200;
        } else if (choice2 == 2) {
            pageMin = 201;
            pageMax = 1000;
        } else if (choice2 == 3) {
            pageMin = 1;
            pageMax = 1000;
        } else {
            System.out.println("Please enter number from 1 to 3!");

            //public void selectyearfilter (Connection conn) throws SQLException {
            System.out.println("When should the book be published? Please choose from the following: " +
                    "\n 1 1980-2000 " +
                    "\n 2 2001-2010 " +
                    "\n 3 2011-2023" +
                    "\n 4 Not important");
            int choice3 = scanner.nextInt();
            int yearmin = 0, yearmax = 0;
            if (choice3 == 1){
                yearmin = 1980;
                yearmax = 2000;
            }else if (choice3 == 2){
                yearmin = 2001;
                yearmax = 2010;
            }else if (choice3 == 3){
                yearmin = 2011;
                yearmax = 2023;
            } else if (choice3 == 4) {
                yearmin = 1980;
                yearmax = 2023;
            } else {
                System.out.println("Please enter number from 1 to 4!");
            }

            try {
                String sql = "SELECT * FROM finalbooks WHERE Genre = ? AND Region = ? AND Pages BETWEEN ? AND ? AND Published BETWEEN ? AND ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, genrefilter);
                preparedStatement.setString(2, regionfilter);
                preparedStatement.setInt(3, pageMin);
                preparedStatement.setInt(4, pageMax);
                preparedStatement.setInt(5, yearmin);
                preparedStatement.setInt(6, yearmax);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String Author = resultSet.getString(2);
                    String Region = resultSet.getString(3);
                    String Title = resultSet.getString(4);
                    int Pages = resultSet.getInt(5);
                    int Published = resultSet.getInt(6);
                    int OriginalYear = resultSet.getInt(7);
                    String Genre = resultSet.getString(8);

                    String output = "Author: %s, Region: %s, Title: %s, Pages: %d, Published: %d, Original Year: %d";
                    System.out.println(String.format(output, Author, Region, Title, Pages, Published, OriginalYear, Genre));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

