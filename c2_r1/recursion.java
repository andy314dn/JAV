/* Iterative */
public static long factorial(int n)
{
    long fact = 1;
    for (int i = 1; i <= n; i++) {
        fact = fact * i;
    }
    return fact;
}

/* Recursive */
public static long factorial(int n)
{
    if (n == 0) {
        return 1;
    } else {
        return factorial(n - 1) * n;
    }
}

public static void main(String[] args)
{
    long x = factorial(3);
}
