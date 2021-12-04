package basicStructures;

import org.junit.Assert;
import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class testBSTree {
    @Test
    public void testRoot() {
        TreeNode<Integer> root = new TreeNode<>(5);
        BSTree<Integer> tree = new BSTree<>(root);
        Assert.assertEquals(root, tree.getRoot());
        Assert.assertEquals(root.getValue(), tree.getRoot().getValue());
    }

    @Test
    public void testToString() {
        TreeNode<Integer> root = new TreeNode<>(5);
        BSTree<Integer> tree = new BSTree<>(root);

        TreeNode<Integer> l1 = new TreeNode<>(3);
        TreeNode<Integer> r1 = new TreeNode<>(6);
        root.setLeft(l1);
        root.setRight(r1);

        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> lr1 = new TreeNode<>(2);
        l1.setLeft(ll1);
        l1.setRight(lr1);

        TreeNode<Integer> rr1 = new TreeNode<>(7);
        r1.setRight(rr1);

        System.out.println(tree.toString());
    }

    @Test
    public void testMinHeightBST() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        BSTree<Integer> tree = (new BSTree<Integer>(null)).fromList(list);
        System.out.println(tree.toString());

        // level 1 test
        Assert.assertEquals(tree.getRoot().getLeft().getValue(), Integer.valueOf(1));
        Assert.assertEquals(tree.getRoot().getRight().getValue(), Integer.valueOf(5));

        // level 2 test left
        TreeNode<Integer> l1lroot = tree.getRoot().getLeft();
        Assert.assertNull(l1lroot.getLeft());
        Assert.assertEquals(l1lroot.getRight().getValue(), Integer.valueOf(2));

        // level 2 test right
        TreeNode<Integer> l1rroot = tree.getRoot().getRight();
        Assert.assertEquals(l1rroot.getLeft().getValue(), Integer.valueOf(4));
        Assert.assertEquals(l1rroot.getRight().getValue(), Integer.valueOf(6));
    }
}
