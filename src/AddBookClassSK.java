import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;


public class AddBookClassSK {


    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String user = "root";
        String password = "vilmas12";
        Scanner scanner = new Scanner(System.in);


        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

            System.out.println("Connected to database");



            // this will happen after in main choosing "Add a new book"

            String author;
            while (true) {
                System.out.println("Enter the author of book");
                author = scanner.nextLine();
                if (checkIfValid(author)) {
                    System.out.println("Name of the author accepted.");
                    break;
                } else {
                    System.out.println("Name of the author must not contain characters other than letters and spaces. Please try again.");
                }
            }

            System.out.println("Enter the title of book");
            String title = scanner.nextLine();
            System.out.println("Title accepted.");

            String region = chooseRegion();

            System.out.println("Enter number of pages in the book (numbers only!");
            int pageCount = scanner.nextInt();
            System.out.println("Page Count accepted");


            int publYear;
            while (true) {
                System.out.println("Please enter books publishing year:");
                publYear = scanner.nextInt();
                if (isValidYear(publYear)) {
                    System.out.println("Year accepted" );
                    break;
                }
                System.out.println("Invalid year. Please enter a valid year between 1 and current year inclusive.");
            }

            int origYear;
            while (true) {
                System.out.println("Please enter book`s first year of publishing:");
                origYear = scanner.nextInt();
                if (isValidYear(origYear)) {
                    System.out.println("Year accepted" );
                    break;
                }
                System.out.println("Invalid year. Please enter a valid year between 1 and current year inclusive.");
            }

            scanner.skip(".*\n");
            String genre;
            while (true) {
                System.out.println("Enter the category of book");
                genre = scanner.nextLine();
                if (checkIfValid(genre)) {
                    System.out.println("Category accepted.");
                    break;
                } else {
                    System.out.println("Category must not contain characters other than letters and spaces. Please try again.");
                }
            }

            insertData (conn, author, region, title, pageCount, publYear, origYear, genre );




        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void insertData (Connection conn, String author, String region, String title,
            int pageNumber, int yearPublished, int originalYear, String genre ) throws SQLException {

                String sql = "INSERT INTO Finalbooks (Author, Region, Title, Pages, Published, OriginalYear, Genre) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, author);
                statement.setString(2, region);
                statement.setString(3, title);
                statement.setInt(4, pageNumber);
                statement.setInt(5, yearPublished);
                statement.setInt(6, originalYear);
                statement.setString(7, genre);

                int rowInserted = statement.executeUpdate();

                if (rowInserted > 0) {
                    System.out.println("New book added successfully!");

                } else {
                    System.out.println("Something went wrong");

                }


            }

    public static boolean checkIfValid (String name){
        return Pattern.matches("^[a-zA-Z ]+$", name);

    }

    public static String chooseRegion() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose a part of the world the author is from:");
            System.out.println("\t 1 - Europe");
            System.out.println("\t 2 - Asia");
            System.out.println("\t 3 - South America");
            System.out.println("\t 4 - North America");
            System.out.println("\t 5 - Australia");
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
                    return "Australia";
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
    }

    public static boolean isValidYear(int year) {
        int currentYear = LocalDate.now().getYear();
        return (year >= 1 && year <= currentYear);
    }





}


