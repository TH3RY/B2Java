package Serie3Package;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstname;
    private String lastname;
    private SchoolYear schoolYear;

    public Student(String firstname, String lastname, SchoolYear schoolYear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.schoolYear = schoolYear;
    }

    public String toString() {
        return firstname + " " + lastname + " est étudiant(e) en " + schoolYear;
    }
}
