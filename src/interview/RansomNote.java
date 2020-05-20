package interview;

import java.util.Arrays;
import java.util.Scanner;

public class RansomNote {

  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {
    Arrays.sort(magazine);
    Arrays.sort(note);
    int mCounter = 0;
    for (String nWord : note) {
      char firstCharN = nWord.charAt(0);
      boolean found = false;
      for (int i = mCounter; i < magazine.length && firstCharN >= magazine[i].charAt(0); i++) {
        if (nWord.equals(magazine[i])) {
          found = true;
          mCounter = i + 1;
          break;
        }
      }
      if (!found) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
