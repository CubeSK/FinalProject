import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.util.Scanner;

public class BookSK {

    private String author;
    private String region;
    private String title;
    private int pageCount;
    private int yearPublished;
    private int originalYear;
    private String genre;

    public boolean setAuthor (String author) {
        if (checkIfValid(author)) {
            this.author= author;
            System.out.println("Name of the author accepted.");
            return true;
        } else {
            System.out.println("Name of the author must not contain characters other than letters and spaces. Please try again.");
            return false;
        }
    }

    public void setRegion(String region )  {
        this.region = region;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("Title accepted.");

    }
    public int getPageCount() {
        Scanner scanner = new Scanner(System.in);
        int pageCount = 0;
        while (true) {
            System.out.println("Enter number of pages in the book (numbers only)!");
            try {
                pageCount = scanner.nextInt();
                if (isNumberOfPagesCorrect(pageCount)) {
                    System.out.println("Number of pages accepted");
                    break;
                } else {
                    System.out.println("The provided number is incorrect.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return pageCount;
    }

    public int getYearPublished() {
        Scanner scanner = new Scanner(System.in);
        int publYear;
        while (true) {
            System.out.println("Please enter books publishing year:");
            publYear = scanner.nextInt();
            if (isValidYear(publYear)) {
                System.out.println("Year accepted" );
                break;
            }
            System.out.println("Invalid year. Please enter a valid year between 1450 and current year inclusive");
        }
        return publYear;
    }
    public int getOriginalYear() {
        Scanner scanner = new Scanner(System.in);
        int origYear;
        while (true) {
            System.out.println("Please enter books publishing year:");
            origYear = scanner.nextInt();
            if (isValidYear(origYear)) {
                System.out.println("Year accepted" );
                break;
            }
            System.out.println("Invalid year. Please enter a valid year between 1450 and current year inclusive");
        }
        return origYear;
    }



    public boolean setGenre (String genre) {
        if (checkIfValid(genre)) {
            this.genre = genre;
            System.out.println("Category accepted.");
            return true;
        } else {
            System.out.println("Category name must not contain characters other than letters and spaces. Please try again.");
            return false;
        }
    }



    public static boolean checkIfValid (String name){
        return Pattern.matches("^[a-zA-Z ]*[a-zA-Z][a-zA-Z ]*$", name);

    }
    public static boolean isValidYear(int year) {
        int currentYear = LocalDate.now().getYear();
        return (year >= 1450 && year <= currentYear);
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
    public boolean isNumberOfPagesCorrect(int pageCount) {
        return pageCount >=10;
    }


}





