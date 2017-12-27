package pascalsTriangle;

public class PascalsTriangle {
    private Integer magnitude;
    private Integer[][] tree;

    public PascalsTriangle(Integer magnitude) {
        this.magnitude = magnitude;
        this.tree = new Integer[magnitude][];

        for (Integer i = 0; i < magnitude; i++) {
            this.tree[i] = new Integer[i + 1];
            this.tree[i][0] = 1;

            for (Integer j = 1; j < i; j++) {
                this.tree[i][j] = this.tree[i - 1][j - 1] + this.tree[i - 1][j];
            }
            this.tree[i][i] = 1;
        }
    }

    public Integer getMagnitude() {
        return magnitude;
    }

    public Integer[][] getTree() {
        return tree;
    }

    public void printTriangle() {
        for (Integer i = 0; i < this.magnitude; i++) {
            for (Integer j = 0; j < i + 1; j++) {
                System.out.print(this.tree[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
