package problemSolving;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {
    long[] array = new long[n + 1];

    for (int[] query : queries) {
      int startIndex = query[0] - 1;
      int endIndex = query[1];
      int value = query[2];
      array[startIndex] += value;
      array[endIndex] -= value;
    }
    long max = Long.MIN_VALUE;
    long current = 0;
    for (long element : array) {
      current += element;
      if (current > max) max = current;
    }

    return max;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] queries = new int[m][3];

    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    long result = arrayManipulation(n, queries);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();

    scanner.close();
  }
}
