class SectionException extends Exception {
    public static final String[] sections = {"compta", "droit", "market", "info"};

    public SectionException(String message) {
        super(message);
    }
}
