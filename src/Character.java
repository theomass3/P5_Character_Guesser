public class Character {
    private String name, path;

    public Character(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return name + ", " + path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

}
