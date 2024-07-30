package Library;
import java.util.Scanner;

public class Library1 {
    String books[] = new String[10];
    int i = 6; // Updated to account for the initial 6 books
    Scanner sc = new Scanner(System.in);

    public Library1() {
        // Initializing with more books
        books[0] = "C";
        books[1] = "Python";
        books[2] = "Java";
        books[3] = "DBMS-SQL";
        books[4] = "HTML";
        books[5] = "CSS";
        books[6] = "JavaScript";
    }

    public static void main(String[] args) {
        Library1 obj = new Library1();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter 1 to add book\n2 to issue book\n3 to view the books\n4 to return book\n5 to search for a book\n6 to check book availability\n7 to show total number of books\n8 to exit\n:");
            choice = sc.nextInt();
            switch (choice) {
                case 1: 
                    obj.addbook();
                    break;
                case 2: 
                    obj.issuebook();
                    break;
                case 3: 
                    obj.show();
                    break;
                case 4: 
                    obj.returnbook();
                    break;
                case 5: 
                    obj.searchbook();
                    break;
                case 6: 
                    obj.checkavailability();
                    break;
                case 7: 
                    obj.showTotalBooks();
                    break;
                case 8: 
                    System.out.println("Exiting...");
                    break;
                default: 
                    System.out.println("Enter correct choice ");
            }
        } while (choice != 8);
    }

    void addbook() {
        if (i >= books.length - 1) {
            System.out.println("Library is full! Cannot add more books.");
            return;
        }
        System.out.println("Enter book name you want to add:");
        String b = sc.next();
        books[++i] = b;
    }

    void issuebook() {
        System.out.println("Enter the book you want to take:");
        String t = sc.next();
        int flag = 0;

        for (int j = 0; j <= i; j++) {
            if (books[j].equals(t)) {
                flag = 1;
                for (int k = j; k < i; k++) {
                    books[k] = books[k + 1];
                }
                books[i] = null;
                i -= 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not available in the library.");
        }
    }

    void returnbook() {
        if (i >= books.length - 1) {
            System.out.println("Library is full! Cannot return the book.");
            return;
        }
        System.out.println("Enter book name you want to return:");
        String b = sc.next();
        books[++i] = b;
        System.out.println("Book returned successfully.");
    }

    void searchbook() {
        System.out.println("Enter book name you want to search:");
        String b = sc.next();
        for (int j = 0; j <= i; j++) {
            if (books[j].equals(b)) {
                System.out.println("Book found: " + books[j]);
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    void checkavailability() {
        System.out.println("Enter book name you want to check availability for:");
        String b = sc.next();
        for (int j = 0; j <= i; j++) {
            if (books[j].equals(b)) {
                System.out.println("Book is available.");
                return;
            }
        }
        System.out.println("Book is not available.");
    }

    void showTotalBooks() {
        System.out.println("Total number of books in the library: " + (i + 1));
    }

    void show() {
        System.out.println("Books available in the library:");
        for (int k = 0; k <= i; k++) {
            if (books[k] != null) {
                System.out.println(books[k]);
            }
        }
    }
}
