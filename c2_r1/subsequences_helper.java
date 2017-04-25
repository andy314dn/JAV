/** 
 * Return all subsequences of word (as defined above) separated by commas,
 * with partialSubsequence prepended to each one.
 */
private static String subsequencesAfter(String partialSubsequence, String word)
{
    if (word.isEmpty()) {
        // base case
        return partialSubsequence;
    } else {
        // recursive step
        return subsequencesAfter(partialSubsequence, word.substring(1))
            + ","
            + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));
    }
}

public static String subsequences(String word)
{
    return subsequencesAfter("", word);
}


public class seq
{
  public static void main(String[] args)
  {
    System.out.print(subsequences("gc"));  
  }
  
  private static String subsequencesAfter(String partialSubsequence, String word)
  {
    if (word.isEmpty()) {
        // base case
        return partialSubsequence;
    } else {
        // recursive step
        return subsequencesAfter(partialSubsequence, word.substring(1))
            + ","
            + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));
    }
  }

  public static String subsequences(String word)
  {
    return subsequencesAfter("", word);
  }

}