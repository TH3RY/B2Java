import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Student student = null;
        Student student2 = null;

        String firstName;
        String lastName;
        char gender;
        int year;
        int month;
        int day;
        String section;
        int yearNumber;

        try {
            student = new Student("Pierre", "Legrand", 'x', 2003, 10, 21, "info", 2);
            JOptionPane.showMessageDialog(null, student, "Confirmation d’inscription", JOptionPane.PLAIN_MESSAGE);
            do {
                firstName = JOptionPane.showInputDialog(null, "FirstName");
                lastName = JOptionPane.showInputDialog(null, "LastName");
                gender = JOptionPane.showInputDialog(null, "Gender m - f - x").charAt(0);
                year = Integer.parseInt(JOptionPane.showInputDialog(null, "Year"));
                month = Integer.parseInt(JOptionPane.showInputDialog(null, "Month"));
                day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day"));
                section = JOptionPane.showInputDialog(null, "Section {\"compta\", \"droit\", \"market\", \"info\"}");
                yearNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Annee 1 2 3"));
                student = new Student(firstName, lastName, gender, year, month, day, section, yearNumber);
                JOptionPane.showMessageDialog(null, student, "Confirmation d’inscription", JOptionPane.PLAIN_MESSAGE);

            } while (JOptionPane.showConfirmDialog(null, "Voulez vous continuer ?") == JOptionPane.OK_OPTION);
            JOptionPane.showMessageDialog(null, ((double)Person.femaleNb / (double)Person.totalNb) * 100 + " % de femme", "prct female", JOptionPane.PLAIN_MESSAGE);

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