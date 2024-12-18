import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Percolation {
    boolean[][] grid;

    public Percolation(int n) {
        if (n<=0){
            throw new IllegalArgumentException();
        }
        grid = new boolean[n][n];
        for(boolean[] gridRow: grid){
            for(boolean growCol: gridRow){
                Arrays.fill(False);
            }
        }
    }

    public void open(int row, int col){
        if (row <= 0 || col <= 0){
            throw new IllegalArgumentException();
        }
        if (!grid[row][col]){
            grid[row][col] = true;
        }
    }

    public boolean isOpen(int row, int col){
        if (row <= 0 || col <= 0){
            throw new IllegalArgumentException();
        }
        return true;
    }
    public boolean isFull(int row, int col){
        if (row <= 0 || col <= 0){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int numberOfOpenSites(){
        return 1;
    }

    public boolean percolates(){
        return true;
    }

    public static void main(String[] args) {
        try{
            Percolation myPerc = new Percolation(-1);
        }
        catch (IllegalArgumentException ex){
            StdOut.println("Out of range...");
        }
    }
}
