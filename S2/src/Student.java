import java.util.Arrays;

public class Student extends Person {
    private String sectionName;
    private int studyYearNumber;
    private LearningActivity[] learningActivities;

    public Student(String firstname, String lastname, char gender, int year, int month, int day, String sectionName, int studyYearNumber) throws GenderException, YearNumberException, SectionException {
        super(firstname, lastname, gender, year, month, day);
        setSectionName(sectionName);
        setStudyYearNumber(studyYearNumber);
        this.learningActivities = new LearningActivity[LearningActivity.MAX_ACTIVITIES];
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

    public int activitiesNb() {
        int i;
        for (i = 0; i < learningActivities.length; i++) {
            if (learningActivities[i] == null) return i;
        }
        return i - 1;
    }

    public void addLearningActivity(LearningActivity learningActivity) throws TooManyActivities {
        if (activitiesNb() >= LearningActivity.MAX_ACTIVITIES) {
            throw new TooManyActivities();
        }
        learningActivities[activitiesNb()] = learningActivity;
    }

    public LearningActivity getLearningActivity(int index) throws BadPositionException {
        if (activitiesNb() < index || index < 1) {
            throw new BadPositionException(index, activitiesNb());
        }
        return learningActivities[index - 1];
    }

    public String loginName() {
        return sectionName.codePointCount(0, 1) + studyYearNumber + getLastname() + getFirstname().charAt(0);
    }

    @Override
    public String toString() {
        return super.toString() + " est inscrit" + (getGender() == 'f' ? "e" : "") + " en " + studyYearNumber + " " + sectionName + '\n'
                + "Son nom d'utilisateur est " + loginName();
    }
}
class BadPositionException extends Exception {
    private int badNumber;
    private int maxNumber;

    public BadPositionException(int badNumber, int maxNumber) {
        super(badNumber <= 0 ? "Le numéro d’activité d’apprentissage " + badNumber + " que vous avez proposé est <=0" : "L’étudiant n’a que " + maxNumber + " activités d’apprentissage dans son PAE. Le numéro " + badNumber + " que vous avez proposé ne correspond donc pas à une activité d’apprentissage du PAE de cet étudiant");
        this.badNumber = badNumber;
        this.maxNumber = maxNumber;
    }
}
class TooManyActivities extends Exception {
    public TooManyActivities() {
        super(" Le nombre maximum d’activités d’apprentissage permis est déjà atteint !");
    }
}
class SectionException extends Exception {
    public static final String[] sections = {"compta", "droit", "market", "info"};

    public SectionException(String message) {
        super(message);
    }
}
class YearNumberException extends Exception {
    public YearNumberException(String message) {
        super(message);
    }

}