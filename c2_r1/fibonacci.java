/* fibonacci series */

/**
 * @param n >= 0
 * @return the nth Fibonacci number
 */
public static int fibonacci(int n)
{
    if (n == 0 || n == 1) {
        return 1; // base case
    } else {
        return fibonacci(n-1) + fibonacci(n-2); // recursive step
    }
}
