import javax.swing.tree.TreeNode;
import java.io.*;
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

    public static void appendStringToFile(String fileName, String str) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(str);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        ChNode alive1 = new ChNode(null, null, null, 0);
//
//        ChNode human2 = new ChNode(alive1, null, null, 1);
//
//        ChNode force3 = new ChNode(human2, null, null, 3);
//
//        ChNode good4 = new ChNode(force3, null, null, 2);
//
//        ChNode male5 = new ChNode(good4, null, null, 8);
//
//        ChNode good6 = new ChNode(force3, null, null, 2);
//
//        ChNode anh7 = new ChNode(good6, null, null, 6);
//
//        ChNode droid8 = new ChNode(human2, null, null, 4);
//
//        ChNode english9 = new ChNode(droid8, null, null, 7);
//
//        ChNode good10 = new ChNode(droid8, null, null, 2);
//
//        ChNode anh20 = new ChNode(good10, null, null, 6);
//
//        ChNode good12 = new ChNode(alive1, null, null, 2);
//
//        ChNode force13 = new ChNode(good12, null, null, 3);
//
//        ChNode human14 = new ChNode(force13, null, null, 1);
//
//        ChNode anh15 = new ChNode(human14, null, null, 6);
//
//        ChNode male16 = new ChNode(force13, null, null, 8);
//
//        ChNode human17 = new ChNode(force3, null, null, 1);
//
//        ChNode force18 = new ChNode(force3, null, null, 3);
//
//        ChNode rotj19 = new ChNode(force3, null, null, 5);



//        alive1.setLeft(human2);
//        human2.setLeft(force3);
//        force3.setLeft(good4);
//        good4.setLeft(male5);
//
//        force3.setRight(good6);
//        good6.setLeft(anh7);
//
//        human2.setRight(droid8);
//        droid8.setLeft(english9);
//        droid8.setRight(good10);
//
//        good10.setLeft(anh20);
//
//        alive1.setRight(good12);
//        good12.setLeft(force13);
//        force13.setLeft(human14);
//        human14.setLeft(anh15);
//
//        force13.setRight(male16);
//
//        good12.setRight(human17);
//        human17.setLeft(force18);
//
//        human17.setRight(rotj19);


        Character[] characters = createCharacters();
        String path = "";
        Scanner kb = new Scanner(System.in);
        System.out.print("Please think of a character that appears in the original Star Wars trilogy.\nType anything to continue. ");
        String ok = kb.nextLine();

        System.out.println("\nPlease answer each question with yes or no.");

        ChNode currNode = TreeMaker.deserialize();

        while (currNode != null) {
            System.out.println(TreeMaker.getQs().get(currNode.getqValue()));
            String response = kb.nextLine().toLowerCase();

            if (response.equals("yes")) {
                currNode = currNode.getLeft();
                path += "1";
            } else if (response.equals("no")) {
                currNode = currNode.getRight();
                path += "0";
            } else {
                System.out.println("Try again but use yes and no.");
            }
        }

        for (Character character : characters) {
            if (character.getPath().equals(path)) {
                System.out.println("Is your character " + character.getName() + "?");
                String finalQ = kb.nextLine().toLowerCase();

                if (finalQ.equals("yes")) {
                    System.out.println("Yay! We guessed your character!");
                } else {
                    System.out.print("Dang! Who is your character? (Please use their full name) ");
                    appendStringToFile("resources/nodestoadd","\n" + kb.nextLine());
                }
            }
        }


//        Right Branch
    }
}
