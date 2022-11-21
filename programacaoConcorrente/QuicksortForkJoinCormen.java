
import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoinCormen extends RecursiveAction {
  private int[] array; 
  private int inicio; 
  private int fim; 

  // ordena o subarray do índice 'inicio' até 'fim'
  public QuicksortForkJoinCormen(int[] array, int inicio, int fim) {
    this.array = array;
    this.inicio = inicio;
    this.fim = fim;
  }

  // ordenando array
  public QuicksortForkJoinCormen(int[] array) {
    this(array, 0, array.length - 1);
  }

  // executando quicksort com forkjoin
  @Override
  protected void compute() {
    if (inicio < fim) {
      int q = partition(array, inicio, fim); // obtém o pivô (join)
      // realiza as chamadas recursivas paralelamente (fork)
      invokeAll(new QuicksortForkJoinCormen(array, inicio, q - 1),
          new QuicksortForkJoinCormen(array, q + 1, fim));
    }
  }

  // Método de partição
  private static int partition(int[] A, int inicio, int fim) {
    // o pivo é o elemento final
    int pivo = A[fim];
    int i = inicio - 1;
    
    for (int j = inicio; j <= fim - 1; j++) {
      if (A[j] <= pivo) {
        i = i + 1;
        swap(A, i, j);
      }
    }
    // coloca o pivô na posição de ordenação
    swap(A, i + 1, fim);
    return i + 1; // retorna a posição do pivô
  }
  
  private static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
