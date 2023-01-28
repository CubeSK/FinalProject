/*
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;


//public class DBConnection_LT {
//    public void readData() {

    public static void main(String[] args) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java34", "root", "Jautajumsnr6663");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Finalbooks");


        while (rs.next()) {
            System.out.printf("BookID: %d Author: %s Region: %s Title: %s Pages: %d Published: %s \n",
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),  rs.getInt(6));

        }
        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }

}
}

*/
