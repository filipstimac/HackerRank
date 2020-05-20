package interview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps2 {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    int swaps = 0;
    boolean[] visited = new boolean[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (visited[i] == false) {
        int a = i;
        int b = arr[i] - 1;
        int length = 1;
        visited[i] = true;
        while (b != i) {
          a = b;
          visited[b] = true;
          b = arr[b] - 1;
          length++;
        }
        swaps += length - 1;
      }
    }
    return swaps;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
