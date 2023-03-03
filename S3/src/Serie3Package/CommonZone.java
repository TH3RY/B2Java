package Serie3Package;

public class CommonZone {
    private Student student;
    private boolean completed;
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isCompleted() {return this.completed;}
    public void complete () { this.completed = true; }
}
