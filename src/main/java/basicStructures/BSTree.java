package basicStructures;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BSTree(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public BSTree<T> fromList(List<T> list) {
        Integer start = 0;
        Integer end = list.size() - 1;
        Integer mid = (end + start) / 2;
        TreeNode<T> root = new TreeNode<>(list.get(mid));

        fromListHelper(list, start, mid - 1, root);
        fromListHelper(list, mid+1, end, root);

        return new BSTree<T>(root);
    }

    private void fromListHelper(List<T> list, Integer start, Integer end, TreeNode<T> parent) {
        if (start > end) {
            return;
        }

        Integer mid;
        if (start.equals(end)) {
            mid = start;
        } else {
            mid = (end + start) / 2;
        }

        TreeNode<T> nextRoot = new TreeNode<>(list.get(mid));

        if (list.get(mid).compareTo(parent.getValue()) < 0) {
            parent.setLeft(nextRoot);
        } else {
            parent.setRight(nextRoot);
        }

        fromListHelper(list, start, mid-1, nextRoot);
        fromListHelper(list, mid+1, end, nextRoot);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        Integer currentLevel = root.getLevel();
        while (queue.size() > 0) {
            TreeNode<T> n = queue.remove();

            if (n.getLevel() > currentLevel) {
                sb.append("\n");
                currentLevel = n.getLevel();
            }

            sb.append(n.getValue().toString());
            sb.append(" ");

            if (n.getLeft() != null) {
                queue.add(n.getLeft());
            }

            if (n.getRight() != null) {
                queue.add(n.getRight());
            }
        }

        return sb.toString();
    }
}
