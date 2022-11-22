
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Functional {
  public static void main(String[] args) {
    // List usando stream
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    List<String> result = givenList.stream()
        .collect(toList());

    System.out.println(result);

    // Map usando stream

    List<Integer> mapList = Arrays.asList(1, 2, 3, 4, 5);

    Map<Integer, List<Integer>> mapResult = mapList.stream()
        .collect(groupingBy(i -> i < 4 ? 1 : 2));

    System.out.println(mapResult);

    // Set 
    Set<String> setResult = givenList.stream()
        .collect(toSet());

    System.out.println(setResult);

    // Joining para transformar em uma lista só
    List<String> joiningList = Arrays.asList("a", "bb", "ccc", "dd");

    String joiningResult = joiningList.stream()
        .collect(joining(", "));

    System.out.println(joiningResult);

    // Summary Statistics para mostrar estatisticas sobre a lista
    List<Integer> summaryList = Arrays.asList(1, 2, 3, 4, 5);

    IntSummaryStatistics summaryStatistics = summaryList.stream()
        .collect(summarizingInt(Integer::intValue));

    System.out.println(summaryStatistics);

  }

}
