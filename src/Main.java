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
                    appendStringToFile("resources/nodesToAdd","\n" + kb.nextLine());
                }
            }
        }

    }
}
