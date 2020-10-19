public class Book {
    String title;
    Author author;
    Release releases;

    public Book(String title, Author author, Release release) {
        this.title = title;
        this.author = author;
        this.releases = release;
    }
}
