package by.bsuir.iit.ip.constants;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public enum AnaglyphType {
    COLOR(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, new int[][] {
            { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } });

    private int[][] leftMatrix;

    private int[][] rightMatrix;

    private AnaglyphType(int[][] left, int[][] right) {
        leftMatrix = left;
        rightMatrix = right;
    }

    public int[][] getRightMatrix() {

        return rightMatrix;

    }

    public int[][] getLeftMatrix() {

        return leftMatrix;
    }
}
