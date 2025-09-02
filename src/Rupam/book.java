/**This file will hold the detail about each book including their
serial number, Book name, Author name,total qty and available qty and
 the constructor will asks the user to enter these details whenever a new book is added./*
 */
package Rupam;

import java.util.Scanner;

public class book {    // class

    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);


    public book() {    // constr

        // nextInt() and nextLine() standard methods
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();

        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }

}


