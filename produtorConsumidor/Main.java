
import java.util.LinkedList;

public class Main {
  public static void main(String[] args)
      throws InterruptedException {

    final ProduterConsumer pc = new ProduterConsumer();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pc.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pc.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }

  public static class ProduterConsumer {

    // Criando lista do produtor e consumidor
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 5;

    public void produce() throws InterruptedException {
      int value = 0;
      while (true) {
        synchronized (this) {

          while (list.size() == capacity)
            wait();

          System.out.println("Producer produced-"
              + value);

          list.add(value++);

          notify();

          Thread.sleep(500);
        }
      }
    }

    public void consume() throws InterruptedException {
      while (true) {
        synchronized (this) {

          while (list.size() == 0)
            wait();

          int val = list.removeFirst();

          System.out.println("Consumer consumed-"
              + val);

          notify();

          Thread.sleep(500);
        }
      }
    }
  }
}

// fonte
// https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/
