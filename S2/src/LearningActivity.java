public class LearningActivity {
    private String title;
    private Person teacher;
    public final static int MAX_ACTIVITIES = 5;

    public LearningActivity(String title, Person teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "l’activité d’apprentissage intitulée " + title + " donnée par " + teacher + "\n";
    }
}
