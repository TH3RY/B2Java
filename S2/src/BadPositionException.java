class BadPositionException extends Exception {
    private int badNumber;
    private int maxNumber;

    public BadPositionException(int badNumber, int maxNumber) {
        super(badNumber <= 0 ? "Le numéro d’activité d’apprentissage " + badNumber + " que vous avez proposé est <=0" : "L’étudiant n’a que " + maxNumber + " activités d’apprentissage dans son PAE. Le numéro " + badNumber + " que vous avez proposé ne correspond donc pas à une activité d’apprentissage du PAE de cet étudiant");
        this.badNumber = badNumber;
        this.maxNumber = maxNumber;
    }
}
