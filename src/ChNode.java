import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class ChNode implements TreeNode {

    private ChNode parent;
    private ChNode left;
    private ChNode right;

    public ChNode(ChNode parent, ChNode left, ChNode right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

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
}
