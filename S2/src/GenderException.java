class GenderException extends Exception {
    private char wrongGender;

    public GenderException(char wrongGender, String message) {
        super(message);
        setWrongGender(wrongGender);
    }

    public char getWrongGender() {
        return wrongGender;
    }

    public void setWrongGender(char wrongGender) {
        this.wrongGender = wrongGender;
    }
}