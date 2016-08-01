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
public static void main(String[] args) {
	int N = StdIn.readInt();
	UF uf = new UF(N);
	while (!StdIn.isEmpty()) {
		int p = StdIn.readInt();
		int q = StdIn.readInt();
		if (!uf.connected(p, q)) {
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
	}
}

public class QuickFindUF {
	private int[] id;
	
	public QuickFindUF(int N) {
		
	}
	
	public boolean connected(int p, int q) {
		
	}
	
	public void union(int p, int q) {
		
	}
}