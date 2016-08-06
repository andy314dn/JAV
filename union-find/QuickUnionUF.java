import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private int[] id;
    
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
    
    public static void main (String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF quuf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!quuf.connected(p, q)) {
                quuf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
