class TooManyActivities extends Exception {
    public TooManyActivities() {
        super(" Le nombre maximum d’activités d’apprentissage permis est déjà atteint !");
    }
}
