package pascalsTriangle;

import org.junit.Test;

public class testPascalsTriangle {
    @Test
    public void testPrintTriangleDoesntThrow() throws Exception {
        PascalsTriangle triangle = new PascalsTriangle(7);
        triangle.printTriangle();
    }
}
