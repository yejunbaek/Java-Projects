public class Book {

    private String title;
    private String author;
    private int year;
    private static int ID = 0;

    public Book(String title, String author, int year, int quantity) {
        this.title = title;
        this.author = author;
        this.year = year;
        ID++;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 0;
        ID++;
    }

    public Book(String title) {
        this.title = title;
        this.author = "Unknown";
        this.year = 0;
        ID++;
    }

    public int getID() {
        return ID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }

}
