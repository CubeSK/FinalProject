import java.sql.*;
import java.util.Scanner;
import java.util.Random;


public class SelectABookSK {


    public static void selectBook(Connection conn) throws SQLException {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";



        System.out.println("What genre would you like to read? Please choose from the following: " +
                "\n 1 History " +
                "\n 2 Romance " +
                "\n 3 Parenting " +
                "\n 4 Politics " +
                "\n 5 Hobbies ");
        //"\n 6 Not important");
        String genrefilter = null;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > 5) {
            choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println(ANSI_RED + "You did not enter a number from 1 to 6. Please try again: " + ANSI_RESET);
            }
        }
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
            //} else if (choice == 6) {
            //genrefilter = "History"+ " " + "Romance"+ " " + "Parenting"+ " " + "Politics"+ " " + "Hobbies";
        }


        System.out.println("Which region should the author come from? Please choose from the following: " +
                "\n 1 Europe " +
                "\n 2 Asia " +
                "\n 3 North America " +
                "\n 4 South America ");
        //"\n 5 Not important");
        String regionfilter = null;
        Scanner scanner1 = new Scanner(System.in);
        int choice1 = 0;
        while (choice1 < 1 || choice1 > 4) {
            choice1 = scanner.nextInt();
            if (choice1 < 1 || choice1 > 4) {
                System.out.println(ANSI_RED + "You did not enter a number from 1 to 5. Please try again: " + ANSI_RESET);
            }
        }
        if (choice1 == 1) {
            regionfilter = "Europe";
        } else if (choice1 == 2) {
            regionfilter = "Asia";
        } else if (choice1 == 3) {
            regionfilter = "North America";
        } else if (choice1 == 4) {
            regionfilter = "South America";
            //} else if (choice1 == 5) {
            //regionfilter = "Europe" + "Asia" + "North America" + "South America";
        }

        System.out.println("How many pages a day do you want to read?");
        int pagesWant = 0;
        int maxNumber = 0;
        boolean valid = false;

        while (!valid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a positive number:");
                scanner.next();
            }
            pagesWant = scanner.nextInt();
            if (pagesWant >= 0) {
                valid = true;
            } else {
                System.out.println("Please enter a positive number:");
            }
        }

        System.out.println("Max number of days you would like to finish reading a book?");
        valid = false;
        while (!valid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a positive number:");
                scanner.next();
            }
            maxNumber = scanner.nextInt();
            if (maxNumber >= 0) {
                valid = true;
            } else {
                System.out.println("Please enter a positive number:");
            }
        }

        int pagesToSearch = maxNumber * pagesWant;
        System.out.println("Based on the numbers provided, offered books will have maximum of " + pagesToSearch + " pages");



        System.out.println("When should the book be published? Please choose from the following: " +
                "\n 1 Before 1980" +
                "\n 2 1980-2000 " +
                "\n 3 2001-2010 " +
                "\n 4 2011-2023" +
                "\n 5 Not important");
        Scanner scanner2 = new Scanner(System.in);
        int choice3 = scanner.nextInt();
        int yearmin = 0, yearmax = 0;
        while (choice3 < 1 || choice3 > 6) {
            System.out.println(ANSI_RED + "You did not enter a number from 1 to 6. Please try again: " + ANSI_RESET);
            choice3 = scanner2.nextInt();
        }
        if (choice3 == 2) {
            yearmin = 1980;
            yearmax = 2000;
        }else if (choice3 == 1) {
            yearmin = 1400;
            yearmax = 1979;
        }else if (choice3 == 3){
            yearmin = 2001;
            yearmax = 2010;
        }else if (choice3 == 4){
            yearmin = 2011;
            yearmax = 2023;
        }else if (choice3 == 5) {
            yearmin = 1400;
            yearmax = 2023;
        }



        System.out.println("When should the book be written (originally published)? Please choose from the following: " +
                "\n 1 Up to 18th century" +
                "\n 2 18th century " +
                "\n 3 19th century " +
                "\n 4 20th century" +
                "\n 5 21st century" +
                "\n 6 Not important");
        Scanner scanner3 = new Scanner(System.in);
        int origyearmin = 0, origyearmax = 0;
        int choice4 = scanner.nextInt();

        while (choice4 < 1 || choice4 > 6) {
            System.out.println(ANSI_RED + "You did not enter a number from 1 to 6. Please try again: " + ANSI_RESET);
            choice4 = scanner3.nextInt();
        }
        if (choice4 == 2) {
            origyearmin = 1700;
            origyearmax = 1799;
        } else if (choice4 == 1)   {
            origyearmin = 0;
            origyearmax = 1699;
        } else if (choice4 == 3) {
            origyearmin = 1800;
            origyearmax = 1899;
        } else if (choice4 == 4){
            origyearmin = 1900;
            origyearmax = 1999;
        } else if (choice4 == 5) {
            origyearmin = 2000;
            origyearmax = 2023;
        } else if (choice4 == 6) {
            origyearmin = 1700;
            origyearmax = 2023;
        }

        try {
            String sql = "SELECT * FROM finalbooks WHERE Genre = ? AND Region = ? AND Published BETWEEN ? AND ? AND OriginalYear BETWEEN ? AND ? AND PAGES BETWEEN 0 and ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, genrefilter);
            preparedStatement.setString(2, regionfilter);
            preparedStatement.setInt(3, yearmin);
            preparedStatement.setInt(4, yearmax);
            preparedStatement.setInt(5, origyearmin);
            preparedStatement.setInt(6, origyearmax);
            preparedStatement.setInt(7, pagesToSearch);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Please find following books matching your criteria:");

            if(!resultSet.next()){
                System.out.println(ANSI_RED + "We did not find any matching book!" + ANSI_RESET);
            } else {
                do {
                    String Author = resultSet.getString(2);
                    String Region = resultSet.getString(3);
                    String Title = resultSet.getString(4);
                    int Pages = resultSet.getInt(5);
                    int Published = resultSet.getInt(6);
                    int OriginalYear = resultSet.getInt(7);
                    String Genre = resultSet.getString(8);


                    String output = "Author: %s, Region: %s, Title: %s, Pages: %d, Published: %d, Original Year: %d, Genre: %s";
                    System.out.println(ANSI_GREEN + String.format(output, Author, Region, Title, Pages, Published, OriginalYear, Genre) + ANSI_RESET);
                } while (resultSet.next());
            }





        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

