package PackageS52;

import java.util.Date;

public class Student {
    private int matricule;
    private String firstName;
    private String lastName;
    private String birthday;
    private boolean hasScolarship;
    private boolean isForeigner;
    private Origin origin;
    private boolean isNewStudent;
    public Student(int matricule, String firstName, String lastName, String birthday, boolean hasScolarship, boolean isForeigner, int origin, boolean isNewStudent) {
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.hasScolarship = hasScolarship;
        this.isForeigner = isForeigner;
        if (isForeigner) {
            this.origin = switch (origin) {
                case 0 -> Origin.EUROPE;
                case 1 -> Origin.AFRICA;
                case 2 -> Origin.ASIA;
                case 3 -> Origin.AMERICA;
                default -> Origin.OCEANIA;
            };
        } else {
            this.origin = Origin.EUROPE;
        }
        this.isNewStudent = isNewStudent;
    }

    @Override
    public String toString() {
        return "matricule: " + matricule +
                "\nfirstName: " + firstName +
                "\nlastName: " + lastName +
                "\nbirthday: " + birthday +
                "\nhasScolarship: " + hasScolarship +
                "\nisForeigner: " + isForeigner +
                "\norigin: " + origin.toString();
    }
}
