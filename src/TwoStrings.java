import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwoStrings {

  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    char[] s1Array = s1.toCharArray();
    char[] s2Array = s2.toCharArray();
    Arrays.sort(s2Array);
    Arrays.sort(s1Array);
    int s2Counter = 0;
    for (char s1Character : s1Array) {
      for (int i = s2Counter; i < s2Array.length && s2Array[i] <= s1Character; i++) {
        if (s2Array[i] == s1Character) {
          return "YES";
        } else {
          s2Counter = i + 1;
        }
      }
    }
    return "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s1 = scanner.nextLine();

      String s2 = scanner.nextLine();

      String result = twoStrings(s1, s2);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
