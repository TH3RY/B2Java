public class ScientificBook extends Book{
    private int appendixPagesNb;

    public ScientificBook(String title, int editionYear, Editor editor, int tableOfContentPagesNb, int prefacePagesNb, int contentPagesNb, int appendixPagesNb) {
        super(title, editionYear, editor, tableOfContentPagesNb, prefacePagesNb, contentPagesNb);
        setAppendixPagesNb(appendixPagesNb);
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
        this.appendixPagesNb = appendixPagesNb;
    }
}
