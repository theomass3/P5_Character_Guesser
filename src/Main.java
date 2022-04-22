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
        ChNode alive1 = new ChNode(null, null, null, 1);
//        Left Branch
        ChNode human2 = new ChNode(alive1, null, null, 1);

        ChNode force3 = new ChNode(human2, null, null, 1);

        ChNode good4 = new ChNode(force3, null, null, 1);

        ChNode male5 = new ChNode(good4, null, null, 1);

        ChNode good6 = new ChNode(force3, null, null, 1);

        ChNode anh7 = new ChNode(good6, null, null, 1);

        ChNode droid8 = new ChNode(human2, null, null, 1);

        ChNode english9 = new ChNode(droid8, null, null, 1);

        ChNode good10 = new ChNode(droid8, null, null, 1);

        ChNode anh20 = new ChNode(good10, null, null, 1);

        ChNode good12 = new ChNode(alive1, null, null, 1);

        ChNode force13 = new ChNode(good12, null, null, 1);

        ChNode human14 = new ChNode(force13, null, null, 1);

        ChNode anh15 = new ChNode(human14, null, null, 1);

        ChNode male16 = new ChNode(force13, null, null, 1);

        ChNode human17 = new ChNode(force3, null, null, 1);

        ChNode force18 = new ChNode(force3, null, null, 1);

        ChNode rots19 = new ChNode(force3, null, null, 1);

        alive1.setLeft(human2);
        human2.setLeft(force3);
        force3.setLeft(good4);
        good4.setLeft(male5);

        force3.setRight(good6);
        good6.setLeft(anh7);

        human2.setRight(droid8);
        droid8.setLeft(english9);
        droid8.setRight(good10);

        good10.setLeft(anh20);

        alive1.setRight(good12);
        good12.setLeft(force13);
        force13.setLeft(human14);
        human14.setLeft(anh15);

        force13.setRight(male16);

        good12.setRight(human17);
        human17.setLeft(force18);

        human17.setRight(rots19);






//        Right Branch
    }
}
