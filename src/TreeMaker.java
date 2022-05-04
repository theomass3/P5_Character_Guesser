
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeMaker {

        private static ArrayList<String> qs = new ArrayList<>();

    public static ArrayList<String> getQs() {
        return qs;
    }

    public static ChNode deserialize(){
        // TODO: take the file path as a parameter for greater flexibility.
        String str = "";
        try {
            Scanner list = new Scanner(new File("resources/tree.txt"));
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
        // TODO: take the file path as a parameter for greater flexibility.
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

