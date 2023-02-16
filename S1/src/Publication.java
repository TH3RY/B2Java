import java.time.Year;

public class Publication {
    private String title;
    private Year editionYear;
    private Editor editor;
    public Publication(String title, int editionYear, Editor editor) {
        this.title = title;
        setEditionYear(Year.of(editionYear));
        this.editor = editor;
    }

    public void setEditionYear(Year editionYear) {
        if (editionYear.isAfter(Year.now())) {
            this.editionYear = Year.now();
        } else {
            this.editionYear = editionYear;
        }
    }

    public Editor getEditor() {
        return editor;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return "l'ouvrage";
    }
    @Override
    public String toString() {
        return getType() + " édité en "+ editionYear + " par " + editor;
    }
}
