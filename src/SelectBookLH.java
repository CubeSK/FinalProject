import java.sql.*;
import java.util.Scanner;

public class SelectBookLH {
    private static final String ANSI_RED = "\\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

    }
    public void selectgenrefilter(Connection conn) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int genre = scanner.nextInt();
        System.out.println("What genre would you like to read? Please choose from the following: " +
                "\n 1 History " +
                "\n 2 Romance " +
                "\n 3 Parenting " +
                "\n 4 Politics " +
                "\n 5 Hobbies " +
                "\n 6 Not important");
        int choice = scanner.nextInt();
        String genrefilter;
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
            System.out.println(ANSI_RED
                    + "Please enter number from 1 to 6"
                    + ANSI_RESET);
        }
    }

    public void selectregionfilter(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int region = scanner.nextInt();
        System.out.println("Which region should the author come from? Please choose from the following: " +
                "\n 1 Europe " +
                "\n 2 Asia " +
                "\n 3 North America " +
                "\n 4 South America " +
                "\n 5 Not important");
        int choice = scanner.nextInt();
        String regionfilter;
        if (choice == 1) {
            regionfilter = "Europe";
        } else if (choice == 2) {
            regionfilter = "Asia";
        } else if (choice == 3) {
            regionfilter = "North America";
        } else if (choice == 4) {
            regionfilter = "South America";
        } else if (choice == 5) {
            regionfilter = "Europe" + "Asia" + "North America" + "South America";
        } else {
            System.out.println(ANSI_RED
                    + "Please enter number from 1 to 5!"
                    + ANSI_RESET);
        }
    }

    /*public void selectpagefilter (Connection conn) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int pages = scanner.nextInt();
        System.out.println("How many pages should the book have? Please choose from the following: " +
                "\n 1 less than 200 " +
                "\n 2 more than 200 " +
                "\n 3 Not important");
        int choice = scanner.nextInt();
        int pagefilter;
        if (choice ==1){
            pagefilter < 200;
        } else if (choice == 2) {
            pagefilter > 200;
        } else if (choice == 3){
            pagefilter //= any value
        } else {
            System.out.println(ANSI_RED
                    + "Please enter number from 1 to 3!"
                    + ANSI_RESET);


    public void selectyearfilter (Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println("When should the book be published? Please choose from the following: " +
                "\n 1 1980-2000 " +
                "\n 2 2001-2010 " +
                "\n 3 2011-2023" +
                "\n 4 Not important");
        int choice = scanner.nextInt();
        int publishyear;
        if (choice == 1){
            publishyear // = 1980-2000;
        }else if (choice == 2){
            publishyear // = 2001-2010;
        }else if (choice == 3){
            publishyear // =2011-2023;
        } else if (choice == 4) {
            publishyear // = any value
        } else {
            System.out.println(ANSI_RED
                    + "Please enter number from 1 to 4!"
                    + ANSI_RESET);
    }

    public void selectoriginalyear (Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int yearoriginal = scanner.nextInt();
        System.out.println("When should the book be written (originally published)? Please choose from the following: " +
                "\n 1 18th century " +
                "\n 2 19th century " +
                "\n 3 20th century" +
                "\n 4 21st century" +
                "\n 5 Not important");
        int choice = scanner.nextInt();
        int origyearfilter;
        if (choise == 1){
            origyearfilter // = 1700-1799;
        } else if (choice == 2) {
            origyearfilter // = 1800=1899;
        } else if (choice == 3){
            origyearfilter //= 1900-1999;
        } else if (choice == 4) {
            regionfilter // = 2000-2023;
        } else if (choice == 5) {
            regionfilter //= any value;
        } else {
            System.out.println(ANSI_RED
                    + "Please enter number from 1 to 5!"
                    + ANSI_RESET);
    }
*/
    public void printchoices(Connection conn) throws SQLException {
        String sql = "SELECT * FROM finalbooks WHERE Genre = ? AND Region = ?";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int BookID = resultSet.getInt(1);
            String Author = resultSet.getString(2);
            String Region = resultSet.getString(3);
            String Title = resultSet.getString(4);
            int Pages = resultSet.getInt(5);
            int Published = resultSet.getInt(6);
            int OriginalYear = resultSet.getInt(7);

            String output = "%d. Author: %s,  Region: %s, Title: %s, Pages: %d, Published: %d, Original Year: %d";
            System.out.println(String.format(output, BookID, Author, Region, Title, Pages, Published, OriginalYear));
        }
    }
    }






