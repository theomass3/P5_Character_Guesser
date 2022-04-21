import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private final static int NUM_CHARACTERS = 20;

    public static Character[] createCharacters() {

        Character[] characters = new Character[NUM_CHARACTERS];

        Scanner list = null;
        try {
            list = new Scanner(new File("resources/characters"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (list != null && list.hasNextLine()) {
            String str = list.nextLine();
            String[] data = str.split(":");
            characters[i] = new Character(data[0], data[1]);
            i++;
        }

        return characters;
    }

    public static void main(String[] args) {
//        ChNode Alive = new ChNode();
    }
}
