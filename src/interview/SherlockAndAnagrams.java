package interview;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndAnagrams {

  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {
    char[] sArray = s.toCharArray();
    int counter = 0;
    for (int i = 0; i < sArray.length; i++) {
      int maxSubstringSize = sArray.length - i - 1;
      for (int j = 1; j <= maxSubstringSize; j++) {
        for (int k = i + 1; k + j <= sArray.length; k++) {
          char[] startingArray = Arrays.copyOfRange(sArray, i, i + j);
          char[] iteratingArray = Arrays.copyOfRange(sArray, k, k + j);
          Arrays.sort(startingArray);
          Arrays.sort(iteratingArray);
          if (Arrays.equals(startingArray, iteratingArray)) {
            counter++;
          }
        }
      }
    }
    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = sherlockAndAnagrams(s);

      //      bufferedWriter.write(String.valueOf(result));
      //      bufferedWriter.newLine();
    }

    //    bufferedWriter.close();

    scanner.close();
  }
}
