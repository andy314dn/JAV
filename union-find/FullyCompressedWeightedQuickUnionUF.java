import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class FullyCompressedWeightedQuickUnionUF
{
    private int[] id, sz;
    
    public FullyCompressedWeightedQuickUnionUF(int N)
    {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    
    private int root(int p)
    {
        int the_root = p;
        while (the_root != id[the_root])
            the_root = id[the_root];
        while (p != the_root) {
            int new_p = id[p];
            id[p] = the_root;
            p = new_p;
        }
        return the_root;
    }
    
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    
    public static void main(String[] args)
    {
        Stopwatch stopwatch = new Stopwatch();
        int N = StdIn.readInt();
        FullyCompressedWeightedQuickUnionUF fcwquuf = 
            new FullyCompressedWeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!fcwquuf.connected(p, q)) {
                fcwquuf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        double time = stopwatch.elapsedTime();
        StdOut.println("time = " + time);
    }
}
