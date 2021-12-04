package util;

public class TreeNode<T> extends NodeImpl<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private Integer level = 0;

    public TreeNode(T value) {
        super(value);
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
        this.left.setLevel(this.level + 1);
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
        this.right.setLevel(this.level + 1);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
