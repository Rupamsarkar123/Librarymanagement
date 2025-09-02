package Rupam;


import java.util.Scanner;

public class books {

    book theBook[] = new book[50];
    public static  int count;

    Scanner input = new Scanner(System.in);

    // method 1 --> comparing books
    public int compareBook(book b1, book b2){

        if(b1.bookName.equalsIgnoreCase(b2.bookName)){

            System.out.println("Arey yaar ye kitaab to pehele se mojud hain kuch aur naam do!");
            return 0;
        }
        if(b1.sNo == b2.sNo){

            System.out.println("Arey yaar is kitaab ka serial no  pehele se available  hain!");
            return 0;
        }
        return 1;
    }

    // method 2 --> add book functionality

    public void addBook(book b){

        for (int i =0; i<count; i++){

            if( compareBook(b, this.theBook[i]) ==0) {
                System.out.println("Arey ye kitab hain pehle se hi!");
                return;

            }
        }
        if(count<50){
            theBook[count] = b;
            count++;
        }else{
            System.out.println("Aur jagah nhi bacha yaar sorry :)");
        }
    }

    // method 3 --> search by serial no

    public void seachBysNo(){

        System.out.println(" \"\\t\\t\\t\\t SERIAL NUMBER SE SEARCH KARO\\n");

        int sNo;

        System.out.println("Serial no  dijiye :");
        sNo = input.nextInt();

        boolean found  = false;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for(int i =0; i<count; i++){

            if(theBook[i].sNo ==sNo ){
                System.out.println(
                        theBook[i].sNo + "\t\t"
                                + theBook[i].bookName + "\t\t"
                                + theBook[i].authorName + "\t\t"
                                + theBook[i].bookQtyCopy + "\t\t"
                                + theBook[i].bookQty);

                found = true;
                break;
            }


        }
        if(!found){
            System.out.println("Sorry yaar is " +sNo+" no se kuch mila nhi! :) ");
        }

    }

    // method 4 => search by  authorName

    public  void searchbyAuthor(){

        System.out.println(" \"\\t\\t\\t\\t AUTHOR K NAME SE SEARCH KARO\\n");
        input.nextLine();
        System.out.println("Author kaa name dijiye janab!");
        String authorName = input.nextLine();

        boolean found = false;
        System.out.println(
                "            \"S.No\\t\\tName\\t\\tAuthor\\t\\tAvailable Qty\\t\\tTotal Qty\");");

        for (int i =0; i<count; i++){

            if(theBook[i].authorName == authorName){
                System.out.println(
                        theBook[i].sNo + "\t\t"
                                + theBook[i].bookName + "\t\t"
                                + theBook[i].authorName + "\t\t"
                                + theBook[i].bookQtyCopy + "\t\t"
                                + theBook[i].bookQty);

                found = true;
                return;

            }

            if(!found){
                System.out.println("is"+authorName+ "naam se koi kitab nhi mila :(");
            }
        }


    }

    // method 5 => show all books
    public void showAllBooks()
    {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    theBook[i].sNo + "\t\t"
                            + theBook[i].bookName + "\t\t"
                            + theBook[i].authorName + "\t\t"
                            + theBook[i].bookQtyCopy + "\t\t"
                            + theBook[i].bookQty);
        }
    }

    // method 6 => edit book qty

    public void upgradeBookQty()
    {
        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println(" Serial No do  Book ka");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBook[i].sNo) {

                // Display message
                System.out.println(
                        "kitna books add krna hain:");

                int addingQty = input.nextInt();
                theBook[i].bookQty += addingQty;
                theBook[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    // mehtod -7 => menu creation

    public void dispMenu()
    {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    // Method 8
    // To search the library
    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBook[i].sNo) {
                if (theBook[i].bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number "
                + " Available in Library.");
        return -1;
    }

    // Method 9
    // To remove the book from the library
    public book checkOutBook()
    {

        System.out.println(
                "Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBook[bookIndex].bookQtyCopy--;
            return theBook[bookIndex];
        }
        return null;
    }

    // Method 10
    // To add the Book to the Library
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBook[i])) {
                theBook[i].bookQtyCopy++;
                return;
            }
        }
    }
}









