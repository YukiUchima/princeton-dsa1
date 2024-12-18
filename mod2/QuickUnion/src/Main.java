public class Main {
    public static void main(String[] args) {
        QuickUnion newUnion = new QuickUnion(10);
        //id:    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        //root:  [0, 8, 2, 0, 3, 5, 4, 1, 8, 9]

//        newUnion.union(1, 2);
//        newUnion.union(3,4);
//        newUnion.union(4,1);
//        newUnion.union(9,8);
//        newUnion.union(9,2);
//        newUnion.union(5,4);
        newUnion.union(4,3);
        newUnion.union(3,8);
        newUnion.union(6,5);
        newUnion.union(9,4);
        newUnion.union(2,1);
        newUnion.union(5,0);
        newUnion.union(7,2);
        newUnion.union(6,1);
        newUnion.union(7,3);



        newUnion.connected(6,3); // true
        newUnion.connected(4,3); // true
        newUnion.connected(8,7); // true
        newUnion.connected(7,2); // false
    }
}
