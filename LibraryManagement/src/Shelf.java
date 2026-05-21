
import java.util.HashMap;


public class Shelf {
    private HashMap<Book, Integer> Books;
    private int nob = 0;
    int MAX_BOOKS;

    public Shelf(int MAX_BOOKS) {
        Books = new HashMap<>();
        this.MAX_BOOKS = MAX_BOOKS;
    }

    public void addBook(Book book) throws MaxBooksExceededException {
        if (!isFull()) {
            Books.put(book, Books.getOrDefault(book, 0) + 1);
            nob++;
        } else {
            throw new MaxBooksExceededException("Shelf is full. Cannot add more books.");
        }
    
    }

    public HashMap<Book, Integer> getBooks() {
        return Books;
    }



    public int getNumberOfBooks() {
        return nob;
    }

    public int getNumberOfCopies(Book book) {
        return Books.getOrDefault(book, 0);
    }

    public int getRemainingCapacity() {
        return MAX_BOOKS - nob;
    }

    public void removeBook(int bookID) throws NotEnoughQuantityException {
        for (Book book : Books.keySet()) {
            if (book.getID() == bookID) {
                int quantity = Books.get(book);
                if (quantity > 0) {
                    Books.put(book, quantity - 1);
                    nob--;
                    return;
                } else {
                    throw new NotEnoughQuantityException("No copies of the book are available to remove.");
                }
            }
        }
        throw new NotEnoughQuantityException("Book not found on the shelf.");
    }

    public boolean isBookOnShelf(String title) {
        for (Book book : Books.keySet()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
        
    }

    public boolean isEmpty() {
        return nob == 0;
    }

    public boolean isFull() {
        return nob >= MAX_BOOKS;
    }

    public void clearShelf() {
        Books.clear();
        nob = 0;
    }
    



}