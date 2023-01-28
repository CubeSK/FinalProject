import java.util.Scanner;

public class SelectBookLH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int genre = 0;
        System.out.println("What genre would you like to read? Please choose from the following: " +
                "\n 1 History " +
                "\n 2 Romance " +
                "\n 3 Parenting " +
                "\n 4 Politics " +
                "\n 5 Hobbies " +
                "\n 6 Not important");
        genre = scanner.nextInt();

        int region = 0;
        System.out.println("Which region should the author come from? Please choose from the following: " +
                "\n 1 Europe " +
                "\n 2 Asia " +
                "\n 3 North America " +
                "\n 4 South America " +
                "\n 5 Not important");
        region = scanner.nextInt();

        int pages = 0;
        System.out.println("How many pages should the book have? Please choose from the following: " +
                "\n 1 less than 200 " +
                "\n 2 more than 200 " +
                "\n 3 Not important");
        pages = scanner.nextInt();

        int year = 0;
        System.out.println("When should the book be published? Please choose from the following: " +
                "\n 1 1980-2000 " +
                "\n 2 2001-2010 " +
                "\n 3 2011-2023" +
                "\n 4 Not important");
        year = scanner.nextInt();

        int yearoriginal = 0;
        System.out.println("When should the book be written (originally published)? Please choose from the following: " +
                "\n 1 18th century " +
                "\n 2 19th century " +
                "\n 3 20th century" +
                "\n 4 21th century" +
                "\n 5 Not important");
        yearoriginal = scanner.nextInt();

    }
}