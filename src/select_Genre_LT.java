import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class select_Genre_LT {


    public static void selectGenreH (Connection conn) throws SQLException {

        String sql = "select * FROM finalbooks WHERE Genre = 'History'";
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

    public static void selectGenreR (Connection conn) throws SQLException {

        String sql = "select * FROM finalbooks WHERE Genre = 'Romance'";
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
    public static void selectGenrePAR (Connection conn) throws SQLException {

        String sql = "select * FROM finalbooks WHERE Genre = 'Parenting'";
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
    public static void selectGenrePOL (Connection conn) throws SQLException {

        String sql = "select * FROM finalbooks WHERE Genre = 'Politics'";
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
    public static void selectGenreHOB (Connection conn) throws SQLException {

        String sql = "select * FROM finalbooks WHERE Genre = 'Hobbies'";
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

