import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class ChNode implements TreeNode {

    private ChNode parent;
    private ChNode left;
    private ChNode right;
    private int qValue;

    public ChNode(ChNode parent, ChNode left, ChNode right, int qValue) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.qValue = qValue;
    }

//    public void setParent(ChNode parent) {
//        this.parent = parent;
//    }

//    public ChNode getLeft() {
//        return left;
//    }

    public void setLeft(ChNode left) {
        this.left = left;
    }

//    public ChNode getRight() {
//        return right;
//    }
//
    public void setRight(ChNode right) {
        this.right = right;
    }
//
//    public int getqValue() {
//        return qValue;
//    }
//
//    public void setqValue(int qValue) {
//        this.qValue = qValue;
//    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }

    public String printTree(){
        String str = "" + this.qValue;
        if (this.left != null) str += "(" + this.left.printTree() + ")";
        else str += "n";
        if (this.right != null) str += "(" + this.right.printTree() + ")";
        else str += "n";
        return str;
    }
}
