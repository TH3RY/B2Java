package Serie3Package;

import java.io.Serializable;

public class SchoolYear implements Serializable {
    private String sectionName;
    private int year;
    private AcademicDegree academicDegree;

    public SchoolYear(String sectionName, int year, AcademicDegree academicDegree) {
        this.sectionName = sectionName;
        this.year = year;
        this.academicDegree = academicDegree;
    }

    public String toString() {
        return (academicDegree == AcademicDegree.BACHELOR ? "bac" : "master") + " " + year + " en " + sectionName;
    }
}
