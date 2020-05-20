package interview;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CountTriplets {

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    long counter = 0;
    Map<Long, List<Long>> mapLvl2 = new HashMap<>();
    List<Long> listWithoutLvl2 = new ArrayList<>(arr);
    for (Long value : arr) {
      if (value / r != 0 && (value / r) % r == 0) {
        if (mapLvl2.containsKey(value / r / r)) {
          List<Long> newList = new ArrayList<>(mapLvl2.get(value / r / r));
          newList.add(value);
          mapLvl2.put(value / r / r, newList);
        } else {
          mapLvl2.put(value / r / r, Collections.singletonList(value));
        }
      }
    }
    Map<Long, List<Long>> mapLvl1 = new HashMap<>();
    List<Long> listWithoutLvl1 = new ArrayList<>(listWithoutLvl2);
    for (Long value : listWithoutLvl2) {
      if (value / r != 0 && value % r == 0) {
        if (mapLvl1.containsKey(value / r)) {
          List<Long> newList = new ArrayList<>(mapLvl1.get(value / r));
          newList.add(value);
          mapLvl1.put(value / r, newList);
        } else {
          mapLvl1.put(value / r, Collections.singletonList(value));
        }
      }
    }
    for (Long number : listWithoutLvl1) {
      if (mapLvl2.containsKey(number) && mapLvl1.containsKey(number)) {
        counter += mapLvl2.get(number).size() * mapLvl1.get(number).size();
      }
    }
    return counter;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(nr[0]);

    long r = Long.parseLong(nr[1]);

    List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong).collect(toList());

    long ans = countTriplets(arr, r);

    //    bufferedWriter.write(String.valueOf(ans));
//    bufferedWriter.newLine();

    bufferedReader.close();
//    bufferedWriter.close();
  }
}
