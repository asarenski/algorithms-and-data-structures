package util;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void hasValue() {
        Integer expectedValue = 5;
        TreeNode<Integer> n = new TreeNode<>(expectedValue);
        Assert.assertEquals(expectedValue, n.getValue());
    }

    @Test
    public void initWithNullLeftAndRight() {
        TreeNode<Integer> n = new TreeNode<>(5);
        Assert.assertNull(n.getLeft());
        Assert.assertNull(n.getRight());
    }

    @Test
    public void hasLeftAndRight() {
        TreeNode<Integer> n = new TreeNode<>(5);
        TreeNode<Integer> left = new TreeNode<>(4);
        TreeNode<Integer> right = new TreeNode<>(6);

        n.setLeft(left);
        n.setRight(right);

        Assert.assertEquals(left, n.getLeft());
        Assert.assertEquals(right, n.getRight());
    }
}
