import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
    private int[] unionArray;
    private int[] arrSize;

    public QuickUnion(int n) {
        unionArray = new int[n];
//        unionArray = new int[]{0, 8, 2, 0, 3, 5, 4, 1, 8, 9};
        arrSize = new int[n];
        for(int i = 0; i < n; i++){
            unionArray[i] = i;
            arrSize[i] = 1;
        }
    }

    public boolean connected(int p, int q){
        int i = findRoot(p);
        int j = findRoot(q);
        boolean res = i == j;
        StdOut.printf("Is %d and %d have the same root?: %d / %d => %b", p, q, i,j, res);
        StdOut.println();
        return res;
    }

    private int findRoot(int id){
        while (unionArray[id] != id) {
            unionArray[id] = unionArray[unionArray[id]]; // parent of the parent (2 levels up)
            id = unionArray[id];
        }
        return id;
    }

    public void union(int p, int q){
        //unionArray:    [0, 8, 2, 0, 3, 5, 4, 1, 8, 9]
        //root:          [0, 8, 2, 0, 3, 5, 4, 1, 8, 9]
        int i = findRoot(p); // 4 => 0
        int j = findRoot(q); // 7 => 8
        if (i == j) return;
        if (arrSize[i] < arrSize[j]){
            unionArray[i] = j; arrSize[j] += arrSize[i];
        }
        else {
            unionArray[j] = i; arrSize[i] += arrSize[j];
        }
    }
}

// arr:  [0,1,2,3,4,5,6,7,8]
// size: [1,1,1,1,1,1,1,1,1]