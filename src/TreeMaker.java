import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeMaker {

    private static String st = "0(L1(L3(L2(L8nn)n)(R2(L6nn)n))(R4(L7nn)(R2(L6nn)n)))(R2(L3(L1(L6nn)n)(R8nn))(R1(L3nn)(R5nn)))  ";
//    private static String[] questions = {"Is this character alive at the end of Return of the Jedi?", "Is this character a human?", "Is this character Good?","Is this character Force Sensitive?","Is this character a Droid?","Does this character appear in Return of the Jedi?","Does this character appear in A New Hope?","Does this character speak English?","Is this character Male?"};
    private static ArrayList<String> qs = new ArrayList<>();

    public static ArrayList<String> getQs() {
        return qs;
    }

    public static ChNode deserialize(){
        String str = "";
        try {
            Scanner list = new Scanner(new File("resources/tree.txt"));
//            questions = new String[10];
            str = list.nextLine();
            while (list.hasNextLine()){
                str = list.nextLine();
                qs.add(str);
            }
            list = new Scanner(new File("resources/tree.txt"));
            str = list.nextLine();
            return createStructure(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ChNode createStructure(String tree){
        int i = 1;
        ChNode currNode = new ChNode(0);
        ChNode root = currNode;
        while (i+2 < tree.length()){
            if (tree.substring(i, i+2).equals("(L")){
                currNode.setLeft(createNode((tree.charAt(i+2)-48), currNode));
                currNode = currNode.getLeft();
                i+=3;
            }
            if (tree.substring(i, i+2).equals("(R")){
                currNode.setRight(createNode((tree.charAt(i+2)-48), currNode));
                currNode = currNode.getRight();
                i+=3;
            }
            if (tree.charAt(i) == ')'){
                currNode = currNode.getParent();
                i++;
            }
            if (tree.charAt(i) == 'n'){
                i++;
            }
//            System.out.println(i);
        }
        return root;
    }

    public static ChNode createNode(int qValue, ChNode parent){

        return new ChNode(parent, null, null, qValue);}


    public static void main(String[] args) {
        serialize(deserialize());
    }

    public static void serialize(ChNode root){
        String str = root.printTree() + "  ";
        try{
            FileWriter writeTree = new FileWriter("resources/tree.txt");
            writeTree.write(str);
            for (String q: qs){
                writeTree.write('\n' + q);
            }
            writeTree.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}

