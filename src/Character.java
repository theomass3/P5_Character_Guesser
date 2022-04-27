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

//    private static String st = "1(L2(L4(L3(L9nn)n)(R3(L7nn)n))(R5(L8nn)(R3(L7nn)n)))(R3(L4(L2(L7nn)n)(R9nn))(R2(L4nn)(R6nn)))  ";
//    private static String[] questions = {"Is this character alive at the end of Return of the Jedi?", "Is this character a human?", "Is this character Good?","Is this character Force Sensitive?","Is this character a Droid?","Does this character appear in Return of the Jedi?","Does this character appear in A New Hope?","Does this character speak English?","Is this character Male?"};
