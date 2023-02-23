import java.time.Year;

public class Book extends Publication implements Paging{
    private int tableOfContentPagesNb;
    private int  prefacePagesNb;
    private int  contentPagesNb;

    public Book(String title, int editionYear, Editor editor, int tableOfContentPagesNb, int prefacePagesNb, int contentPagesNb) {
        super(title, editionYear, editor);
        this.tableOfContentPagesNb = tableOfContentPagesNb;
        this.prefacePagesNb = prefacePagesNb;
        this.contentPagesNb = contentPagesNb;
    }

    public void setTableOfContentPagesNb(int tableOfContentPagesNb) {
        if (tableOfContentPagesNb < 0) tableOfContentPagesNb = 0;
        this.tableOfContentPagesNb = tableOfContentPagesNb;
    }

    public void setPrefacePagesNb(int prefacePagesNb) {
        if (prefacePagesNb < 0) prefacePagesNb = 0;
        this.prefacePagesNb = prefacePagesNb;
    }

    public void setContentPagesNb(int contentPagesNb) {
        if (contentPagesNb < 0) contentPagesNb = 0;
        this.contentPagesNb = contentPagesNb;
    }

    public int getTableOfContentPagesNb() {
        return tableOfContentPagesNb;
    }

    public int getPrefacePagesNb() {
        return prefacePagesNb;
    }

    public int getContentPagesNb() {
        return contentPagesNb;
    }

    @Override
    public int pagesCounting() {
        return tableOfContentPagesNb + contentPagesNb + prefacePagesNb;
    }

    public String getType() {
        return "le livre";
    }

    @Override
    public String toString() {
        return super.toString() + "\ncompte " + pagesCounting() + " pages et est intitulé " + getTitle();
    }
}
