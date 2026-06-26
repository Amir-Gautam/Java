class LibraryItem {
    String title;
    String author;
    String id;

    LibraryItem(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    void getInfo() {
        System.out.println(title + " by " + author + " (ID: " + id + ")");
    }
}

class Book extends LibraryItem {
    private String genre;

    Book(String title, String author, String id, String genre) {
        super(title, author, id);
        this.genre = genre;
    }

    @Override
    void getInfo() {
        System.out.println("Book: " + title + " by " + author + " | Genre: " + genre);
    }
}

class Magazine extends LibraryItem {
    private String publicationFrequency;

    Magazine(String title, String author, String id, String publicationFrequency) {
        super(title, author, id);
        this.publicationFrequency = publicationFrequency;
    }

    @Override
    void getInfo() {
        System.out.println("Magazine: " + title + " | Frequency: " + publicationFrequency);
    }
}

class Newspaper extends LibraryItem {
    private int issueNumber;

    Newspaper(String title, String author, String id, int issueNumber) {
        super(title, author, id);
        this.issueNumber = issueNumber;
    }

    @Override
    void getInfo() {
        System.out.println("Newspaper: " + title + " | Issue No: " + issueNumber);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("Muna Madan", "Laxmi Prasad Devkota", "B001", "Poetry"),
            new Magazine("Himal Khabarpatrika", "Various", "M001", "Fortnightly"),
            new Newspaper("Kantipur Daily", "Editorial Team", "N001", 245)
        };

        for (LibraryItem item : items) {
            item.getInfo();
        }
    }
}
