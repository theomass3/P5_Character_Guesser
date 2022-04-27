public class TreeMaker {

    private static String st = "1(L2(L4(L3(L9nn)n)(R3(L7nn)n))(R5(L8nn)(R3(L7nn)n)))(R3(L4(L2(L7nn)n)(R9nn))(R2(L4nn)(R6nn)))  ";

    public static ChNode deserialize(){
        int i = 1;
        ChNode currNode = new ChNode(1);
        ChNode root = currNode;
        while (i+2 < st.length()){
            if (st.substring(i, i+2).equals("(L")){
                currNode.setLeft(createNode((st.charAt(i+2)-48), currNode));
                currNode = currNode.getLeft();
                i+=3;
            }
            if (st.substring(i, i+2).equals("(R")){
                currNode.setRight(createNode((st.charAt(i+2)-48), currNode));
                currNode = currNode.getRight();
                i+=3;
            }
            if (st.charAt(i) == ')'){
                currNode = currNode.getParent();
                i++;
            }
            if (st.charAt(i) == 'n'){
                i++;
            }
            System.out.println(i);
            System.out.println(currNode);
        }
        return root;
    }

    public static ChNode createNode(int qValue, ChNode parent){

        return new ChNode(parent, null, null, qValue);}


    public static void main(String[] args) {
        System.out.println(deserialize().printTree());
    }

    public static void serialize(ChNode root){
        String str = root.printTree() + "  ";

    }

}

