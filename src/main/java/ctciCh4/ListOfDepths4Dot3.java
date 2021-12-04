package ctciCh4;

import util.TreeNode;

import java.util.*;

public class ListOfDepths4Dot3 {
    private List<List<TreeNode<Integer>>> lists;
    private Queue<TreeNode<Integer>> queue;
    private TreeNode<Integer> root;

    public ListOfDepths4Dot3(TreeNode<Integer> root) {
        this.root = root;
    }

    public void loadLists() {
        lists = new ArrayList<>();
        queue = new LinkedList<>();

        root.setLevel(0);
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode<Integer> curr = queue.remove();
            if (curr.getLevel() == null) {
                curr.setLevel(curr.getParent().getLevel() + 1);
            }

            List<TreeNode<Integer>> listAtCurrDepth;
            try {
                listAtCurrDepth = lists.get(curr.getLevel());
            } catch (IndexOutOfBoundsException e) {
                listAtCurrDepth = new LinkedList<>();
                lists.add(listAtCurrDepth);
            }

            listAtCurrDepth.add(curr);

            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }

            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
    }

    public List<TreeNode<Integer>> getListAtDepth(Integer depth) {
        return lists.get(depth);
    }
    
    public void printLists() {
        for (List<TreeNode<Integer>> linkedList : this.lists) {
            StringBuilder sb = new StringBuilder();
            linkedList.forEach(integerTreeNode -> {
                sb.append(integerTreeNode.getValue());
                sb.append(" ");
            });
            System.out.println(sb.toString());
        }
    }
}
