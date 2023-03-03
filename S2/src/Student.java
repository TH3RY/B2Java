public class Student extends Person {
    private sectionNameEnum sectionName;
    public enum sectionNameEnum {
        compta("compta"), droit("droit"), market("market"), info("info");

        public String toString() {
            return asString;
        }

        private final String asString;

        sectionNameEnum(String asString) {
            this.asString = asString;
        }
    }
    private studyYearNumberEnum studyYearNumber;

    public enum studyYearNumberEnum {
        first('1'), second('2'), third('3');

        public char toChar() {
            return asChar;
        }

        private final char asChar;

        studyYearNumberEnum(char asChar) {
                this.asChar = asChar;
            }

    }
    private LearningActivity[] learningActivities;

    public Student(String firstname, String lastname, GenderEnum gender, int year, int month, int day, sectionNameEnum sectionName, studyYearNumberEnum studyYearNumber) throws GenderException, YearNumberException, SectionException {
        super(firstname, lastname, gender, year, month, day);
        setSectionName(sectionName);
        setStudyYearNumber(studyYearNumber);
        this.learningActivities = new LearningActivity[LearningActivity.MAX_ACTIVITIES];
    }

    public void setSectionName(sectionNameEnum sectionName) {
        this.sectionName = sectionName;
    }

    public void setStudyYearNumber(studyYearNumberEnum studyYearNumber) {
        this.studyYearNumber = studyYearNumber;
    }

    public int activitiesNb() {
        int i;
        for (i = 0; i < learningActivities.length; i++) {
            if (learningActivities[i] == null) return i;
        }
        return i;
    }

    public void addLearningActivity(LearningActivity learningActivity) throws TooManyActivities {
        if (activitiesNb() >= LearningActivity.MAX_ACTIVITIES) {
            throw new TooManyActivities();
        }
        System.out.println(activitiesNb());
        learningActivities[activitiesNb()] = learningActivity;
    }

    public LearningActivity getLearningActivity(int index) throws BadPositionException {
        if (activitiesNb() < index || index < 1) {
            throw new BadPositionException(index, activitiesNb());
        }
        return learningActivities[index - 1];
    }

    public String loginName() {
        return sectionName.toString().substring(0,1) + studyYearNumber + getLastname() + getFirstname().charAt(0);
    }

    @Override
    public String toString() {
        return super.toString() + " est inscrit" + (getGender() == 'f' ? "e" : "") + " en " + studyYearNumber.asChar + " " + sectionName.toString()
                + '\n'
                + "Son nom d'utilisateur est " + loginName();
    }
}

