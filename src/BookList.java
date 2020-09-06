import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {
    List<Book> myBooks = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void add() {
        System.out.println("Enter information for the new book:");

        System.out.print("ID: ");
        String id = input.nextLine();

        System.out.print("Title: ");
        String title = input.nextLine();

        System.out.print("Author: ");
        String author = input.nextLine();

        System.out.print("Is borrowed (1 = yes, 0 = no): ");
        String choice = input.next();

        boolean isBorrowed = switch (choice) {
            case "1" -> true;
            case "0" -> false;
            default -> false;
        };

        addToList(id.toUpperCase(), title, author, isBorrowed);
        System.out.println("A new book has been added");

    }

    private void addToList(String id, String title, String author, Boolean isBorrowed) {
    Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
    myBooks.add(book);
    }

    public void searchBook() {
        List<Book> booksFound = new ArrayList<>();
        System.out.println("Enter book titile to search");
        System.out.print("Book title: ");

        String searchKey = input.next();
        for (Book book: myBooks) {
            if(book.getTitle().contains(searchKey)) {
                booksFound.add(book);
            }
        }
        if(booksFound.isEmpty()) {
            System.out.println("No book is found");
        } else {
            System.out.printf("%-10s%-20s%-20s%-20s%n", "ID",
                    "Title", "Author", "Is borrowed");
            for (Book book: booksFound) {
                System.out.println(book.toString());
            }
        }
    }

    public void displayBooks() {
        System.out.printf("%-10s%-20s%-20s%-20s%n", "ID",
                "Title", "Author", "Is borrowed");
        for (Book book:myBooks) {
            System.out.println(book.toString());
        }
        System.out.println("---------------------------------------");
    }

    public void borrow() {
        System.out.println("Enter a book ID to borrow: ");
        System.out.print("Book ID: ");
        String searchKey = input.next();

        for (Book abook: myBooks) {
            if (abook.getId().equalsIgnoreCase(searchKey)) {
                if(abook.getBorrowed()){
                    System.out.println("You cannot borrow this book. The book has been borrowed.");
                }
                abook.setBorrowed(true);
                System.out.println("You have successfully borrowed the book: " + abook.getTitle());
            } else {
                System.out.println("There is no such book in library.");
            }
        }
    }
}
