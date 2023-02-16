public class Editor {
    private String name;
    private City city;

    public Editor(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "les éditions " + name;
    }
}
