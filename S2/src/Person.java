import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Person extends Exception {
    private String firstname;
    private String lastname;
    private char gender;
    private LocalDate birthdate;
    public static int femaleNb = 0;
    public static int totalNb = 0;


    public Person(String firstname, String lastname, char gender, int year, int month, int day) throws GenderException {
        this.firstname = firstname;
        this.lastname = lastname;
        setGender(gender);
        this.birthdate = LocalDate.of(year, month, day);
        totalNb++;
    }

    public int age() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setGender(char gender) throws GenderException {
        if (gender != 'm' && gender != 'f' && gender != 'x') {
            String message = "La valeur " + gender + " est invalide";
            throw new GenderException(gender, message);
        }
        if (gender == 'f') femaleNb++;
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " (" + age() + " ans)";
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