import java.time.LocalDate;

public class Person extends Exception{
    private String firstname;
    private String lastname;
    private char gender;
    private LocalDate birthdate;

    public Person(String firstname, String lastname, char gender, int year, int month, int day) throws GenderException {
        this.firstname = firstname;
        this.lastname = lastname;
        setGender(gender);
        this.birthdate = LocalDate.of(year,month,day);
    }

    public void setGender (char gender) throws GenderException {
        if (gender != 'm' && gender != 'f' && gender != 'x') {
            String message = "La valeur " + gender + " est invalide";
            throw new GenderException(gender, message);
        }
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}

class GenderException extends Exception {
    private char wrongGender;
    public GenderException(char wrongGender, String message) {
        super(message);
        setWrongGender(wrongGender);
    }
    public char getWrongGender() {
        return wrongGender;
    }
    public void setWrongGender(char wrongGender) {
        this.wrongGender = wrongGender;
    }
}