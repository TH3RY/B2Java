import java.time.Year;

public class Main {
    public static void main(String[] args) {
        ScientificBook scientificBook = new ScientificBook("Livre scientifique", 2009,new Editor("Editor",new City("Arlon",10000)),5,2,100,5);
        ScientificBook scientificBook1 = new ScientificBook("Livre scientifique", 2009,new Editor("Editor",new City("Arlon",10000)),5,2,200,5);
        ScientificBook scientificBook2 = new ScientificBook("Livre scientifique", 2009,new Editor("Editor",new City("Arlon",10000)),5,2,110,5);
        System.out.println(scientificBook);
        System.out.println(scientificBook.getEditor().getName());
        System.out.println(scientificBook.getEditor().getCity().getInhabitantNb());
        Author author = new Author("Thérence", "Guerenne");
        author.addBook(scientificBook);
        Book book1 = new Book("titreosef", 1999,new Editor("Editor",new City("Arlon",10000)),5,2,100);
        author.addBook(book1);
        System.out.println(author.booksListing());
        System.out.println(ScientificBook.pagesNbAverage());
        scientificBook1.setPrefacePagesNb(59);
        System.out.println(ScientificBook.pagesNbAverage());
    }
}