import java.security.SecureRandom;
import java.util.*;

public class Main implements Runnable {
    private int tickCount;
    private Delivery delivery;
    private Box box_1;
    private Box box_2;
    private Assistant assistant1;
    private Boolean assistant1Busy = false;
    private int ticksNow;
    private Shelve shelf;
    static List<Books> FictionShelf = new ArrayList<Books>();
    static List<Books> HorrorShelf = new ArrayList<Books>();
    static List<Books> SportShelf = new ArrayList<Books>();
    static List<Books> FantasyShelf = new ArrayList<Books>();
    static List<Books> RomanceShelf = new ArrayList<Books>();
    static List<Books> CrimeShelf = new ArrayList<Books>();
    static List<Books> fiction = new ArrayList<Books>();
    static List<Books> horror = new ArrayList<Books>();
    static List<Books> sport = new ArrayList<Books>();
    static List<Books> fantasy = new ArrayList<Books>();
    static List<Books> romance = new ArrayList<Books>();
    static List<Books> crime = new ArrayList<Books>();


    public Main() {
        tickCount = 0;
        delivery = new Delivery(); // create a new Delivery instance for each thread
        box_1 = new Box();
        box_2 = new Box();
        assistant1 = new Assistant();
        shelf = new Shelve();
    }

    public void run() {
        long threadId = Thread.currentThread().getId();

        // Box box_1 = box.CreateNewBox();
        // Box box_2 = box.CreateNewBox();
        int deliveryTime = delivery.NextDeliveryTime();
        System.out.println("Time: " + deliveryTime);
        while (tickCount < 101) {
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
                    System.out.println(box_1);

                    List<Books> box1 = box_1.FillBox(new ArrayList<>(deliveredContents1));
                    // System.out.println("1: " + deliveredContents1);
                    System.out.println("Box 1: " + box1);
                    System.out.println(box1.size());

                    deliveredContents1.clear();
                }
            }
            if (box_1.size() != 0) {
                if (assistant1Busy == false) {
                    assistant1.takeBooksFromBox(box_1);
                    ticksNow = tickCount;
                    assistant1Busy = true;
                }
            }
            // System.out.println("Ticks now: " + ticksNow);
            // System.out.println("TickCount: " + tickCount);
            if (assistant1Busy == true) {
                if (tickCount == ticksNow + 10) {
                    for (Books book : assistant1.getBooks()) {
                        if (book.toString().equals("Fiction")) {
                            FictionShelf.add(book);
                        } else if (book.toString().equals("Horror")) {
                            HorrorShelf.add(book);
                        } else if (book.toString().equals("Sport")) {
                            SportShelf.add(book);
                        } else if (book.toString().equals("Fantasy")) {
                            FantasyShelf.add(book);
                        } else if (book.toString().equals("Romance")) {
                            RomanceShelf.add(book);
                        } else if (book.toString().equals("Crime")) {
                            CrimeShelf.add(book);
                        }
                    }
                    if(!FictionShelf.isEmpty()){
                        fiction = shelf.StackFictionShelf(FictionShelf);
                        System.out.println(fiction);

                    }
                    if(!HorrorShelf.isEmpty()){
                        horror = shelf.StackHorrorShelf(HorrorShelf);
                        System.out.println(horror);

                    }
                    if(!SportShelf.isEmpty()){
                        sport = shelf.StackSportShelf(SportShelf);
                    }
                    if(!FantasyShelf.isEmpty()){
                       fantasy = shelf.StackFantasyShelf(FantasyShelf);
                    }
                    if(!RomanceShelf.isEmpty()){
                        romance = shelf.StackRomanceShelf(RomanceShelf);
                    }
                    if(!CrimeShelf.isEmpty()){
                        crime = shelf.StackCrimeShelf(CrimeShelf);
                    }
                }

            }
            // if (threadId == 15) {
            // List<Books> deliveredContents2 = delivery.GenerateDelivery();
            // System.out.println(box_2);
            // List<Books> box2 = box_2.FillBox(new ArrayList<>(deliveredContents2));
            // System.out.println("2: " + deliveredContents2);
            // System.out.println("Box 2: " + box2);
            // deliveredContents2.clear();
            // }
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
