import javax.swing.*;

public class PAEManagement {
    public static void main(String[] args) {
        try {
            Person prof1 = new Person("Thérence", "Guerenne-Courtois", 'm',2003,10,21);
            Person prof2 = new Person("Martin", "Giroux", 'f',2001,2,19);
            Person prof3 = new Person("Pierre-Lou", "Nihoul", 'm',2001,2,19);
            LearningActivity learningActivity1 = new LearningActivity("PPOO",prof1);
            LearningActivity learningActivity2 = new LearningActivity("OS",prof2);
            LearningActivity learningActivity3 = new LearningActivity("Math",prof3);
            Student student =  new Student("Pierre", "Legrand", 'm', 2003, 10, 21, "info", 2);
            student.addLearningActivity(learningActivity1);
            student.addLearningActivity(learningActivity2);
            student.addLearningActivity(learningActivity3);
            student.addLearningActivity(learningActivity1);
            student.addLearningActivity(learningActivity2);
            student.addLearningActivity(learningActivity3);
            System.out.println(student.activitiesNb());
            for (int i = 1; i <= student.activitiesNb();i++) {
                System.out.println(student.getLearningActivity(i));
            }
        } catch (GenderException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Valeur pour le genre non acceptée", JOptionPane.ERROR_MESSAGE);
        } catch (YearNumberException e) {
            throw new RuntimeException(e);
        } catch (SectionException e) {
            throw new RuntimeException(e);
        } catch (TooManyActivities e) {
            throw new RuntimeException(e);
        } catch (BadPositionException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
