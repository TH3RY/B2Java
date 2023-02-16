public class Author {
    private String firstName;
    private String lastName;
    private Book [] books;

    public final int bookNbMax = 10;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = new Book[bookNbMax];

    }

    public int booksNb() {
        int bookNb = 0;
        for (Book book: books) {
            if (book != null) bookNb++;
        }
        return bookNb;
    }

    public void addBook(Book newBook) {
        if (booksNb() < bookNbMax) {
            books[booksNb()] = newBook;
        }
    }

    public int countAllBooksPages() {
        int result = 0;
        for (Book book: books) {
            result += book.pagesCounting();
        }
        return result;
    }

    public String booksListing() {
        StringBuilder output = new StringBuilder();
        int nbBooks = booksNb();
        for (int i = 1; i < nbBooks + 1;i++) {
            output.append("présentation du ").append(i == 1 ? "premier" : (i == nbBooks ? "dernier" : i + "eme")).append(" livre écrit par ")
                    .append(firstName).append(" ").append(lastName).append("\n")
                    .append(books[i - 1]).append("\n");
        }
        return output.toString();
    }
}
