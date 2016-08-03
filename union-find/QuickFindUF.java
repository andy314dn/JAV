import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * public class	UF
 * --------------------------------------------------------
 * 				UF(int N)
 *		void	union(int p, int q)
 *		boolean	connected(int p, int q)
 */
 
/**
 * Dynamic-connectivity client
 *		Read in number of objects N from standard input.
 *		Repeat:
 *		- read in pair of integers from standard input
 *		- if they are not yet connected, connect them and print out pair 
 */

public class QuickFindUF {
	private int[] id;
	
	/* set id of each object to itself
	 * (N array accesses)
	 */
	public QuickFindUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	/* check whether p and q are in the same component
	 * (2 array accesses)
	 */
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	/* change all entries with id[p] to id[q]
	 * (at most 2N+2 array accesses)
	 */
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid)
				id[i] = qid;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickFindUF qfuf = new QuickFindUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!qfuf.connected(p, q)) {
				qfuf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
	}
}

/**
 * Compile: javac-algs4 QuickFindUF.java
 * Execute: java-algs4 QuickFindUF < tinyUF.txt
 * checkstyle: checkstyle-algs4 QuickFindUF.java
 * findbugs: findbugs-algs4 QuickFindUF.class
 */
