public static String subsequences(String word)
{
    if (word.isEmpty()) {
        return ""; // base case
    } else {
        char firstLetter = word.charAt(0);
        String restOfWord = word.substring(1);
        
        String subsequencesOfRest = subsequences(restOfWord);
        
        String result = "";
        for (String subsequence : subsequencesOfRest.split(",", -1)) {
            result += "," + subsequence;
            result += "," + firstLetter + subsequence;
        }
        result = result.substring(1); // remove extra leading
        
        return result;
    }
}

/* Online IDE: https://www.compilejava.net/
   With Debugger: http://www.pythontutor.com/visualize.html#mode=edit */
public class seq 
{
  public static void main(String[] args) 
  {
    System.out.println(subsequences("c"));
    System.out.println(subsequences("gc"));
    System.out.println(subsequences("gdb"));
  }
  
  public static String subsequences(String word)
  {
    if (word.isEmpty()) {
      return "";
    } else {
      char firstLetter = word.charAt(0);
      String restOfWord = word.substring(1);
      
      String subsequencesOfRest = subsequences(restOfWord);
      
      String result = "";
      for (String subsequence : subsequencesOfRest.split(",", -1)) {
        result += "," + subsequence;
        result += "," + firstLetter + subsequence;
      }
      result = result.substring(1); // remove extra leading comma
      
      return result;
    }
  }
}
