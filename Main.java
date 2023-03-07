import java.security.SecureRandom;
import java.util.*;

public class Main implements Runnable {
    private int tickCount;
    Delivery delivery = new Delivery();
    Box box_1 = new Box();
    Box box_2 = new Box();

    public Main() {
        tickCount = 0;
    }

    

    public void run() {
        long threadId = Thread.currentThread().getId();
        
        // Box box_1 = box.CreateNewBox();
        // Box box_2 = box.CreateNewBox();
        int deliveryTime = delivery.NextDeliveryTime();
        System.out.println(deliveryTime);
        while (tickCount < 1000) {
            try {
                Thread.sleep(100); // Sleep for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickCount++;
            // SecureRandom rand = new SecureRandom();

            // int delivery = rand.nextInt(100);
            // System.out.println(tickCount);
            // System.out.println(delivery);

            if (deliveryTime == 0) {
                deliveryTime = 100;
            }
            if (deliveryTime == tickCount) {
                System.out.println("<" + tickCount + "> <" + threadId + ">" + "Recieved a delivery!");
                // List<Books> deliveredContents1 = delivery.GenerateDelivery();
                // List<Books> deliveredContents2 = delivery.GenerateDelivery();

                // System.out.println("1: " + deliveredContents1);
                // System.out.println("2: " + deliveredContents2);
                if (threadId == 14) {
                    List<Books> deliveredContents1 = delivery.GenerateDelivery();
                    List<Books> box1 = box_1.FillBox(new ArrayList<>(deliveredContents1));
                    System.out.println("1: " + deliveredContents1);
                    System.out.println("Box 1: " + box1);
                    System.out.println(box1.size());

                    deliveredContents1.clear();
                }
                // if (threadId == 15) {
                //     List<Books> deliveredContents2 = delivery.GenerateDelivery();
                //     List<Books> box2 = box_2.FillBox(new ArrayList<>(deliveredContents2));
                //     System.out.println("2: " + deliveredContents2);
                //     System.out.println("Box 2: " + box2);
                //     deliveredContents2.clear();
                // }
            }
            if (tickCount % 100 == 0 && tickCount < 1000) {
                deliveryTime = delivery.NextDeliveryTime();
                deliveryTime = deliveryTime + tickCount;
                System.out.println(deliveryTime);
            }
        }
    }

    public static void main(String[] args) {
        Main t1 = new Main();
        Thread thread1 = new Thread(t1);
        // Main t2 = new Main();
        // Thread thread2 = new Thread(t2);
        thread1.start();
        // thread2.start();
    }
}
