import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoinHoare extends RecursiveAction {
  private int[] array; 
  private int inicio; 
  private int fim; 


  public QuicksortForkJoinHoare(int[] array, int inicio, int fim) {
    this.array = array;
    this.inicio = inicio;
    this.fim = fim;
  }

  // ordenando array
  public QuicksortForkJoinHoare(int[] array) {
    this(array, 0, array.length - 1);
  }

  // executando quicksort com forkjoin
  @Override
  protected void compute() {
    if (inicio < fim) {
      int q = partition(array, inicio, fim); // obtém o pivô (join)
      // realiza as chamadas recursivas paralelamente (fork)
      invokeAll(new QuicksortForkJoinHoare(array, inicio, q - 1),
          new QuicksortForkJoinHoare(array, q + 1, fim));
    }
  }


  private static int partition(int[] A, int inicio, int fim) {
    // o pivo é o elemento inicial
    int pivo = A[inicio];
    
    int i = inicio + 1;

    int j = fim;

  
    while (i <= j) {
      /*
       * Este laço irá parar quando encontrar algum elemento
       * à esquerda que é maior que o pivô, pois ele deveria estar na
       * partição direita
       */
      while (i <= j && A[i] <= pivo) {
        i = i + 1;
      }
      while (i <= j && A[j] > pivo) {
        j = j - 1;
      }

      if (i < j) {
        swap(A, i, j);
      }
    }
    swap(A, inicio, j);
    return j; // retorna a posição do pivô
  }

  // método auxiliar para realizar as trocas de elementos
  private static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}