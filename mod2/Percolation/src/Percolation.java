import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int TOP = 0;
    private final boolean[][] opened;
    private final int bottom;
    private final int size;
    private int openSites;
    private final WeightedQuickUnionUF uf;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Provided n is less than 0");
        }
        size = n;
        bottom = size * size + 1;
        uf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
        openSites = 0;
    }

    public void open(int row, int col) {
        checkException(row, col);
        if (!isOpen(row, col)) {
            opened[row - 1][col - 1] = true;
            ++openSites;
        }

        // union TOP with row 1
        if (row == 1) {
            uf.union(getQuickFindIndex(row, col), TOP);
        }
        // union bottom
        if (row == size) {
            uf.union(getQuickFindIndex(row, col), bottom);
        }
        // above
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getQuickFindIndex(row, col), getQuickFindIndex(row - 1, col));
        }
        // below
        if (row < size && isOpen(row + 1, col)) {
            uf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
        }
        // left
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col - 1));
        }
        // right
        if (col < size && isOpen(row, col + 1)) {
            uf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col + 1));
        }
    }

    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return opened[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        checkException(row, col);
        return uf.find(getQuickFindIndex(row, col)) == uf.find(TOP);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return uf.find(bottom) == uf.find(TOP);
    }

    private void checkException(int row, int col) {
        if (row < 1 || col < 1 || row > size || col > size) {
            throw new IllegalArgumentException();
        }
    }

    private int getQuickFindIndex(int row, int col) {
        int qfIndex = col + (row - 1) * size;
        return qfIndex;
    }
}
