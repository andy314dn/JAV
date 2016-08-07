import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class WeightedQuickUnionUF 
{
    private int[] id, size;
    
    public WeightedQuickUnionUF(int N) 
    {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    private int root(int i) 
    {
        while (i != id[i])
            i = id[i];
        return i;
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
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }
    
    public static void main(String[] args) 
    {
        Stopwatch stopwatch = new Stopwatch();
        int N = StdIn.readInt();
        WeightedQuickUnionUF wquuf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!wquuf.connected(p, q)) {
                wquuf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        double time = stopwatch.elapsedTime();
        StdOut.println("time = " + time);
    }
}
