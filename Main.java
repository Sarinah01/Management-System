/* QB-217
Problem Statement: LibraryManagementSystem Management System
You are required to design a LibraryManagementSystem management system in Java using ArrayList. The system should have the following classes:
Book - This class should contain the following attributes: bookId, bookName, author, and quantity. It should also have a method to display book details.
User - This class should contain the following attributes: userId, userName, and booksIssued. It should also have methods to display user details and to issue/return a book.
LibraryManagementSystem - This class should contain an ArrayList to store all the books and an ArrayList to store all the users. It should have methods to add/remove books and users, to display all books/users, to issue/return a book, and to display all books issued by a particular user.
---------------------------------------------------------------*/
import java.util.ArrayList;

class Book {
    private int bookId;
    private String bookName;
    private String author;
    static int quantity;
    
        public Book(int bookId, String bookName, String author, int quantity) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.author = author;
            this.quantity = quantity;
        }
    
        public int getBookId() {
            return bookId;
        }
    
        public String getBookName() {
            return bookName;
        }
    
        public String getAuthor() {
            return author;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public void displayBookDetails() {
            System.out.println("Book ID: " + bookId);
            System.out.println("Book Name: " + bookName);
            System.out.println("Author: " + author);
            System.out.println("Quantity: " + quantity);
            System.out.println("-----------------------------");
        }
    }
    
    class User {
        private int userId;
        private String userName;
        private ArrayList<Book> booksIssued;
    
        public User(int userId, String userName) {
            this.userId = userId;
            this.userName = userName;
            this.booksIssued = new ArrayList<>();
        }
    
        public int getUserId() {
            return userId;
        }
    
        public String getUserName() {
            return userName;
        }
    
        public ArrayList<Book> getBooksIssued() {
            return booksIssued;
        }
    
        public void displayUserDetails() {
            System.out.println("User ID: " + userId);
            System.out.println("User Name: " + userName);
            System.out.println("-----------------------------");
        }
    
        public void issueBook(Book book) {
            if (book.getQuantity() > 0) {
                booksIssued.add(book);
                book.quantity--;
            System.out.println("Book with ID " + book.getBookId() + " issued to user " + userName);
        } else {
            System.out.println("Sorry, the book is out of stock.");
        }
    }

    public void returnBook(Book book) {
        if (booksIssued.contains(book)) {
            booksIssued.remove(book);
            book.quantity++;
            System.out.println("Book with ID " + book.getBookId() + " returned by user " + userName);
        } else {
            System.out.println("User " + userName + " did not borrow this book.");
        }
    }

    public void displayIssuedBooks() {
        if (booksIssued.isEmpty()) {
            System.out.println("User " + userName + " has not borrowed any books.");
        } else {
            System.out.println("Books issued to user " + userName + ":");
            for (Book book : booksIssued) {
                book.displayBookDetails();
            }
        }
    }
}

class LibraryManagementSystem {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book with ID " + book.getBookId() + " added to the LibraryManagementSystem.");
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book with ID " + book.getBookId() + " removed from the LibraryManagementSystem.");
        } else {
            System.out.println("Book with ID " + book.getBookId() + " not found in the LibraryManagementSystem.");
        }
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User with ID " + user.getUserId() + " added to the LibraryManagementSystem.");
    }

    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("User with ID " + user.getUserId() + " removed from the LibraryManagementSystem.");
        } else {
            System.out.println("User with ID " + user.getUserId() + " not found in the LibraryManagementSystem.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the LibraryManagementSystem.");
        } else {
            System.out.println("All books in the LibraryManagementSystem:");
            for (Book book : books) {
                book.displayBookDetails();
            }
        }
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the LibraryManagementSystem.");
        } else {
            System.out.println("All users in the LibraryManagementSystem:");
            for (User user : users) {
                user.displayUserDetails();
            }
        }
    }

    public void issueBookToUser(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book != null && user != null) {
            user.issueBook(book);
        } else {
            System.out.println("Invalid book ID or user ID.");
        }
    }

    public void returnBookFromUser(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book != null && user != null) {
            user.returnBook(book);
        } else {
            System.out.println("Invalid book ID or user ID.");
        }
    }

    public void displayIssuedBooksByUser(int userId) {
        User user = findUserById(userId);

        if (user != null) {
            user.displayIssuedBooks();
        } else {
            System.out.println("Invalid user ID.");
        }
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem LibraryManagementSystem = new LibraryManagementSystem();

        // Adding books to the LibraryManagementSystem
        Book book1 = new Book(1, "Book 1", "Author 1", 5);
        Book book2 = new Book(2, "Book 2", "Author 2", 3);
        Book book3 = new Book(3, "Book 3", "Author 3", 2);
        LibraryManagementSystem.addBook(book1);
        LibraryManagementSystem.addBook(book2);
        LibraryManagementSystem.addBook(book3);

        // Adding users to the LibraryManagementSystem
        User user1 = new User(1, "User 1");
        User user2 = new User(2, "User 2");
        User user3 = new User(3, "User 3");
        LibraryManagementSystem.addUser(user1);
        LibraryManagementSystem.addUser(user2);
        LibraryManagementSystem.addUser(user3);

        // Display all books and users
        LibraryManagementSystem.displayAllBooks();
        LibraryManagementSystem.displayAllUsers();

        // Issue books to users
        LibraryManagementSystem.issueBookToUser(1, 1);
        LibraryManagementSystem.issueBookToUser(1, 2);
        LibraryManagementSystem.issueBookToUser(2, 1);
        LibraryManagementSystem.issueBookToUser(3, 3);

        // Display books issued by a user
        LibraryManagementSystem.displayIssuedBooksByUser(1);
        LibraryManagementSystem.displayIssuedBooksByUser(2);
        LibraryManagementSystem.displayIssuedBooksByUser(3);

        // Return books from users
        LibraryManagementSystem.returnBookFromUser(1, 1);
        LibraryManagementSystem.returnBookFromUser(1, 2);
        LibraryManagementSystem.returnBookFromUser(2, 1);
        LibraryManagementSystem.returnBookFromUser(3, 3);

        // Remove books and users from the LibraryManagementSystem
        LibraryManagementSystem.removeBook(book3);
        LibraryManagementSystem.removeUser(user3);

        // Display all books and users again
        LibraryManagementSystem.displayAllBooks();
        LibraryManagementSystem.displayAllUsers();
    }
}
