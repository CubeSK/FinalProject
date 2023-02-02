# FinalProject

The main purpose of the section is to provide a brief overview of the project idea, the flow and database structure, as well as steps to replicate and set up the database on any user's side.

Process flow overview:

![Screenshot 2023-02-02 at 00 22 36](https://user-images.githubusercontent.com/123201985/216177335-27c58c86-a303-4552-b9cc-7fe22e79d21e.png)


More detailed process flow overview with questions, input from the user and output of the system:

![Book finder_library drawio](https://user-images.githubusercontent.com/123201985/216177721-18870d59-9586-4bae-b402-2eb1350c9cd0.png)


Database structure overview:

![Screenshot 2023-01-30 at 18 42 57](https://user-images.githubusercontent.com/123201985/216178089-66b1b0a8-4251-4c28-aefc-eed7d6db47af.png)

Explanation of the columns used:
Book ID: the ID from 1 onwards, the primary key in the database
Author: The name and surname of the author
Region: The region from which the author is
Title: The full title of the book
Pages: Number of pages in the book
Published: Year that the book was published
OriginalYear: Original year when the book was first published
Genre: The genre of the book


The code is written in Java, total amount of lines and files is x and x respectively.
In order to create the database structure in MySQLWorkbench, the user first needs to run the JavaFInal2.sql queries and make a new project in his/her MySQLWorkbench. Then copy/paste all the lines from JavaFinal2 into your local project and run them.
Connection to SQL when you run Book Finder from your machine:
String dbURL = "jdbc:mysql://localhost:3306/YOURSQLPROJECTNAME";
String username = "root";
String password = "YOURSQLPASSWORD";
try (Connection conn = DriverManager.getConnection(dbURL, YOURUSERNAME, YOURSQLPASSWORD))

You are ready to run Book Finder!
