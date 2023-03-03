import java.time.LocalDate;
import java.time.Period;

public class Person  {
    private String firstname;
    private String lastname;



    private GenderEnum gender;
    private LocalDate birthdate;
    public static int femaleNb = 0;
    public static int totalNb = 0;


    public Person(String firstname, String lastname, GenderEnum gender, int year, int month, int day) throws GenderException {
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

    public void setGender(GenderEnum newGender) /* throws GenderException */  {
        /*if (gender != 'm' && gender != 'f' && gender != 'x') {
            String message = "La valeur " + gender + " est invalide";
            throw new GenderException(gender, message);
        }*/
        if (newGender == GenderEnum.F)
            femaleNb++;
        this.gender = newGender;
    }

    public char getGender() {
        return switch(this.gender) {
            case F -> 'F';
            case M -> 'M';
            default -> 'X';
        };
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " (" + age() + " ans)";
    }
}

