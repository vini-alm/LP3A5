import java.util.concurrent.ForkJoinPool;

public class TestesQuicksortForkJoin {
  public static void main(String[] args) {
    // cria um pool de threads Fork/Join
    ForkJoinPool pool = new ForkJoinPool();

    int[] A = { 5, 2, 7, 6, 2, 1, 0, 3, 9, 4 };

    System.out.println("array inicial = " + arrayToString(A));

    // ***TESTA O QUICKSORT DE HOARE***
    // escolhe como pivo o primeiro elemento do array
    A = new int[] { 5, 2, 7, 6, 2, 1, 0, 3, 9, 4 };
    // tarefa ForkJoin para ordenar o vetor A
    QuicksortForkJoinHoare quicksortTaskHoare = new QuicksortForkJoinHoare(A);
   
    pool.invoke(quicksortTaskHoare);
    System.out.println("Array pós quicksort de Hoare = " + arrayToString(A));

    // ***TESTA O QUICKSORT DE CORMEN***
    // escolhe como pivo o ultimo elemento do array
    QuicksortForkJoinCormen quicksortTaskCormen = new QuicksortForkJoinCormen(A);
   
    pool.invoke(quicksortTaskCormen);
    System.out.println("Array pós Quicksort de Cormen = " + arrayToString(A));
  }

  private static String arrayToString(int[] array) {
    String aux = "[" + array[0];
    for (int i = 1; i < array.length; i++) {
      aux += ", " + array[i];
    }
    return aux + "]";
  }

}

//referencia https://www.blogcyberini.com/2018/09/quicksort-paralelo-em-java-fork-join.html