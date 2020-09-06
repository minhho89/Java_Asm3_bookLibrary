import java.util.Scanner;

public class Manager {

        public static void main(String[] args) {

            BookList books = new BookList();
            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            while(isRunning) {
                System.out.println("Welcome to the online book library");
                System.out.println("-------------------");
                System.out.println("1. Enter a new book");
                System.out.println("2. Search a book by book title");
                System.out.println("3. Display books");
                System.out.println("4. Borrow a book by book id");
                System.out.println("5. Exit");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();

                while(true) {
                    if (choice <= 5) {
                        break;
                    } else {
                        System.out.println("Please choose between 1 ~ 5");
                        System.out.print("Your choice: ");
                        choice = scanner.nextInt();
                    }
                }

                switch (choice) {
                    case 1 -> books.add();
                    case 2 -> books.searchBook();
                    case 3 -> books.displayBooks();
                    case 4 -> books.borrow();
                    case 5 -> isRunning = false;
                }
            }
        }


}
