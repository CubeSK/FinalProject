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

            BookSK book1 = new BookSK();

            String author;
            boolean isValid;

            do {
                System.out.println("Enter the author of book");
                author = scanner.nextLine();

                isValid = book1.setAuthor (author);

            } while (!isValid);


            System.out.println("Enter the title of book");
            String title = scanner.nextLine();
            book1.setTitle(title);

            String chosenRegion = book1.chooseRegion();
            book1.setRegion(chosenRegion);


            int pageCount = book1.getPageCount();


            int publYear = book1.getYearPublished();
            int origYear = book1.getOriginalYear();


            String genre;
            do {
                System.out.println("Enter the category of book");
                genre = scanner.nextLine();

                isValid = book1.setGenre (author);

            } while (!isValid);


            insertData (conn, author, chosenRegion, title, pageCount, publYear, origYear, genre );



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









}


