import java.math.MathContext;

public class ScientificBook extends Book{
    private int appendixPagesNb;

    private static int TOTAL_PAGE_NB = 0;
    private static int SCIENCEBOOK_NB = 0;
    public ScientificBook(String title, int editionYear, Editor editor, int tableOfContentPagesNb, int prefacePagesNb, int contentPagesNb, int appendixPagesNb) {
        super(title, editionYear, editor, tableOfContentPagesNb, prefacePagesNb, contentPagesNb);
        setAppendixPagesNb(appendixPagesNb);
        SCIENCEBOOK_NB++;
        TOTAL_PAGE_NB += pagesCounting();
    }
    @Override
    public void setTableOfContentPagesNb(int tableOfContentPagesNb) {
        if (tableOfContentPagesNb < 0) tableOfContentPagesNb = 0;
        else TOTAL_PAGE_NB -= super.getTableOfContentPagesNb();
        super.setTableOfContentPagesNb(tableOfContentPagesNb);
        TOTAL_PAGE_NB += tableOfContentPagesNb;
    }
    @Override
    public void setPrefacePagesNb(int prefacePagesNb) {
        if (prefacePagesNb < 0) prefacePagesNb = 0;
        else TOTAL_PAGE_NB -= super.getPrefacePagesNb();
        super.setPrefacePagesNb(prefacePagesNb);
        TOTAL_PAGE_NB += prefacePagesNb;

    }
    @Override
    public void setContentPagesNb(int contentPagesNb) {
        if (contentPagesNb < 0) contentPagesNb = 0;
        else TOTAL_PAGE_NB -= super.getContentPagesNb();
        super.setContentPagesNb(contentPagesNb);
        TOTAL_PAGE_NB += contentPagesNb;
    }

    public static double pagesNbAverage() {
        if (SCIENCEBOOK_NB == 0) return 0;
        return (double)TOTAL_PAGE_NB / (double)SCIENCEBOOK_NB;
    }
    @Override
    public int pagesCounting() {
        return super.pagesCounting() + appendixPagesNb;
    }

    @Override
    public String getType() {
        return "l'ouvrage scientifique";
    }

    public void setAppendixPagesNb(int appendixPagesNb) {
        if (appendixPagesNb < 0) appendixPagesNb = 0;
        else TOTAL_PAGE_NB -= this.appendixPagesNb;
        this.appendixPagesNb = appendixPagesNb;
        TOTAL_PAGE_NB += appendixPagesNb;
    }
}
