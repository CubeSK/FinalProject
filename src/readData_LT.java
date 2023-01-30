import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class readData_LT {


    public static void readData(Connection conn) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to choose books genre? y/n");
        char answer = scanner.nextLine().charAt(0);

            if (answer == 'y') {

                    boolean quit = false;

                    do {
                        System.out.println("Choose book genre you want to see? \n" +
                                "H - history, R - romance, PAR - parenting, POL - politics, HOB - hobbies, EXIT - stop listing books by genre");
                        String genreAnswer = scanner.nextLine().trim().toUpperCase().strip();

                    switch (genreAnswer) {

                        case "H":
                            System.out.println("List of History books:  ");
                            select_Genre_LT.selectGenreH(conn);
                            break;
                        case "R":
                            System.out.println("List of Romance books: ");
                            select_Genre_LT.selectGenreR(conn);
                            break;
                        case "PAR":
                            System.out.println("List of Parenting books: ");
                            select_Genre_LT.selectGenrePAR(conn);
                            break;
                        case "POL":
                            System.out.println("List of Politics books: ");
                            select_Genre_LT.selectGenrePOL(conn);
                            break;
                        case "HOB":
                            System.out.println("List of Hobbies books: ");
                            select_Genre_LT.selectGenreHOB(conn);
                            break;
                        case "EXIT":
                            quit = true;
                            System.out.println();
                            printInstructions_LT.printInstructions();
                            break;
                        default:
                            System.out.println("Please enter correct genre!");
                            break;
                    }

                }
                while (!quit);


            } else if (answer == 'n') {

                System.out.println("List of all books:  ");
                String sql = "SELECT * FROM Finalbooks";
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
                    String Genre = resultSet.getString(8);

                    String output = "%d. Author: %s,  Region: %s, Title: %s, Pages: %d, Published: %d, Original Year: %d, Genre: %s ";
                    System.out.println(String.format(output, BookID, Author, Region, Title, Pages, Published, OriginalYear, Genre));

            }

            } else {
                System.out.println("Please answer y (yes) or n (no)! ");
                System.out.println();
                printInstructions_LT.printInstructions();
            }
        }
}


