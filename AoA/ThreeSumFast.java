import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

public class ThreeSumFast
{
    private ThreeSumFast()
    {
    }

    public static int count(int[] a)
    {
        int N = a.length;
        Arrays.sort(a);
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Stopwatch timer = new Stopwatch();
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
        StdOut.println("time = " + timer.elapsedTime());
    }
}

