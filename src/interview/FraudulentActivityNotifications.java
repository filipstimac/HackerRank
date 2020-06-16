package interview;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FraudulentActivityNotifications {

  // Complete the activityNotifications function below.
  static int activityNotifications(int[] expenditure, int d) {
    int count = 0;
    int[] trailingExpenditure = Arrays.copyOfRange(expenditure, 0, d);
    int[] counting = new int[201];

    for (int i = 0; i < d; i++) {
      counting[trailingExpenditure[i]]++;
    }

    for (int i = d; i < expenditure.length; i++) {
      if (expenditure[i] >= doubleMedian(counting, d)) count++;
      counting[expenditure[i - d]]--;
      counting[expenditure[i]]++;
    }

    return count;
  }

  static int doubleMedian(int[] counting, int d) {
    int[] counting2 = Arrays.copyOf(counting, counting.length);
    for (int i = 1; i < counting2.length; i++) {
      counting2[i] += counting2[i - 1];
    }

    int firstIndex = d / 2;
    int first = 0, second = 0;
    if (d % 2 == 0) {
      int secondIndex = firstIndex + 1;
      int i = 0;

      for (; i < 201; i++) {
        if (firstIndex <= counting2[i]) {
          first = i;
          break;
        }
      }
      for (; i < 201; i++) {
        if (secondIndex <= counting2[i]) {
          second = i;
          break;
        }
      }
    } else {
      firstIndex += 1;
      for (int i = 0; i < 201; i++) {
        if (firstIndex <= counting2[i]) {
          first = i * 2;
          break;
        }
      }
    }

    return first + second;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int d = Integer.parseInt(nd[1]);

    int[] expenditure = new int[n];

    String[] expenditureItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int expenditureItem = Integer.parseInt(expenditureItems[i]);
      expenditure[i] = expenditureItem;
    }

    int result = activityNotifications(expenditure, d);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();

    scanner.close();
  }
}
