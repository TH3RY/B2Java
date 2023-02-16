import java.util.Arrays;

public class Student extends Person {
    private String sectionName;
    private int studyYearNumber;

    public Student(String firstname, String lastname, char gender, int year, int month, int day, String sectionName, int studyYearNumber) throws GenderException {
        super(firstname, lastname, gender, year, month, day);
        this.sectionName = sectionName;
        this.studyYearNumber = studyYearNumber;
    }

    public void setSectionName(String sectionName) throws SectionException {
        if (!Arrays.asList(SectionException.sections).contains(sectionName)) {
            String message = "La valeur proposée pour la section est invalide.\n";
            throw new SectionException(message);
        }
        this.sectionName = sectionName;
    }

    public void setStudyYearNumber(int studyYearNumber) throws YearNumberException {
        if (studyYearNumber > 3 || studyYearNumber < 1) {
            String message = " La valeur " + studyYearNumber + " proposée pour l’année est invalide.\n";
            throw new YearNumberException(message);
        }
        this.studyYearNumber = studyYearNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " est inscrit" +(getGender() == 'f' ? "e" : "") + " en " + studyYearNumber + " " + sectionName;
    }
}
class SectionException extends Exception {
    public static final String [] sections = {"compta", "droit", "market", "info"};
    public SectionException(String message) {
        super(message);
    }
}

class YearNumberException extends Exception {
    public YearNumberException(String message) {
        super(message);
    }
}