import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

  // Complete the minimumBribes function below.
//  static void minimumBribes(int[] q) {
//    int bribeCount = 0;
//    boolean tooChaotic = false;
//    for (int i = 0; i < q.length - 1; i++) {
//      int bribesPerNumber = 0;
//      for (int j = i + 1; j < q.length; j++) {
//        if (q[i] > q[j]) bribesPerNumber++;
//        if (bribesPerNumber > 2) tooChaotic = true;
//      }
//      bribeCount += bribesPerNumber;
//    }
//    System.out.println(tooChaotic ? "Too chaotic" : bribeCount);
//  }

  static void minimumBribes(int[] q) {
    int bribeCount = 0;
    boolean tooChaotic = false;
    for (int i = 0; i < q.length; i++) {
      int number = q[i];
      int originalIndex = q[i] - 1;
      if (originalIndex - i > 2) tooChaotic = true;
      for (int j = Math.max(originalIndex - 1, 0); j < i; j++) {
        if (q[j] > originalIndex) bribeCount++;
      }
    }
    System.out.println(tooChaotic ? "Too chaotic" : bribeCount);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }

    scanner.close();
  }
}
