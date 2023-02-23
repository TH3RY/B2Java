import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Student student = null;
        Student student2 = null;

        String firstName;
        String lastName;
        Person.genderEnum gender;
        int year;
        int month;
        int day;
        Student.sectionNameEnum section;
        Student.studyYearNumberEnum yearNumber;

        try {
            student = new Student("Pierre", "Legrand", GenderEnum.X, 2003, 10, 21, Student.sectionNameEnum.info, Student.studyYearNumberEnum.second);
            JOptionPane.showMessageDialog(null, student, "Confirmation d’inscription", JOptionPane.PLAIN_MESSAGE);
            do {
                firstName = JOptionPane.showInputDialog(null, "FirstName");
                lastName = JOptionPane.showInputDialog(null, "LastName");
                switch (JOptionPane.showInputDialog(null, "Gender m - f - x").charAt(0)) {
                    case 'f' -> gender = Person.genderEnum.F;
                    case 'm' -> gender = Person.genderEnum.M;
                    default -> gender = Person.genderEnum.X;
                }
                year = Integer.parseInt(JOptionPane.showInputDialog(null, "Year"));
                month = Integer.parseInt(JOptionPane.showInputDialog(null, "Month"));
                day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day"));
                section = Student.sectionNameEnum.valueOf(JOptionPane.showInputDialog(null, "Section \"compta\", \"droit\", \"market\", \"info\" in lowercase"));
                yearNumber = switch (JOptionPane.showInputDialog(null, "Year 1 - 2 - 3").charAt(0))  {
                    case '1' -> Student.studyYearNumberEnum.first;
                    case '2' -> Student.studyYearNumberEnum.second;
                    case '3' -> Student.studyYearNumberEnum.third;
                    default ->
                            throw new YearNumberException("Erreur année entre 1 et 3");
                };
                student = new Student(firstName, lastName, gender, year, month, day, section, yearNumber);
                JOptionPane.showMessageDialog(null, student, "Confirmation d’inscription", JOptionPane.PLAIN_MESSAGE);

            } while (JOptionPane.showConfirmDialog(null, "Voulez vous continuer ?") == JOptionPane.OK_OPTION);
            JOptionPane.showMessageDialog(null, ((double) Person.femaleNb / (double) Person.totalNb) * 100 + " % de femme", "prct female", JOptionPane.PLAIN_MESSAGE);

        } catch (GenderException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Valeur pour le genre non acceptée", JOptionPane.ERROR_MESSAGE);
        } catch (SectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Section non acceptée", JOptionPane.ERROR_MESSAGE);
        } catch (YearNumberException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Année d’inscription non acceptée", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }
}