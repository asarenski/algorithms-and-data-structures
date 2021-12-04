package ctciCh4;

import basicStructures.BSTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TreeNode;

public class testListOfDepths4Dot3 {
    TreeNode<Integer> root;
    BSTree<Integer> tree;
    ListOfDepths4Dot3 fourDotThree;

    @Before
    public void setUp() throws Exception {
        root = new TreeNode<>(5);
        tree = new BSTree<>(root);

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

        fourDotThree = new ListOfDepths4Dot3(root);
        fourDotThree.loadLists();
    }

    @Test
    public void test() {
        Assert.assertEquals(fourDotThree.getListAtDepth(0).size(), 1);
    }

    @Test
    public void testPrintList() {
        fourDotThree.printLists();
    }
}
