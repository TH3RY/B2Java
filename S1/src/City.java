public class City {
    private String name;
    private int inhabitantNb;

    public City(String name, int inhabitantNb) {
        this.name = name;
        setInhabitantNb(inhabitantNb);
    }

    public void setInhabitantNb(int inhabitantNb) {
        if (inhabitantNb >= 0) {
            this.inhabitantNb = inhabitantNb;
        } else {
            this.inhabitantNb = 0;
        }
    }

    public int getInhabitantNb() {
        return inhabitantNb;
    }
}
