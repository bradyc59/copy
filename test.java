import java.security.SecureRandom;
import java.util.*;

public class test implements Runnable {
    private int tickCount;
    private int ticksLeft;
    private Delivery delivery;
    private Box box;
    // private Box box_2;
    private Assistant assistant1;
    private Assistant assistant2;
    private Boolean assistant1Busy = false;
    private Boolean assistant2Busy = false;
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

    public test() {
        tickCount = 0;
        ticksLeft = 1000;
        delivery = new Delivery(); // create a new Delivery instance for each thread
        box = new Box();
        // box_2 = new Box();
        assistant1 = new Assistant();
        assistant2 = new Assistant();

        shelf = new Shelve();
    }

    public void run() {
        long threadId = Thread.currentThread().getId();
        Object lock = new Object();

        int deliveryTime = delivery.NextDeliveryTime();
        System.out.println("Time: " + deliveryTime);
        while (tickCount < 101) {
            try {
                Thread.sleep(100); // Sleep for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickCount++;
            if (deliveryTime == 0) {
                deliveryTime = 100;
            }
            if (deliveryTime == tickCount) {
                System.out.println("<" + tickCount + "> <" + threadId + ">" + "Recieved a delivery!");
                synchronized (box) {
                    List<Books> deliveredContents1 = delivery.GenerateDelivery();
                    box.FillBox(new ArrayList<>(deliveredContents1));
                    deliveredContents1.clear();
                    System.out.println("<" + tickCount + "> <" + threadId + ">" + " Box: " + box);
                }
            }
            // } else if (threadId == 15) {
            // Thread t2 = new Thread(new Runnable() {
            // public void run() {
            // synchronized (box_2) {
            // List<Books> deliveredContents2 = delivery.GenerateDelivery();
            // box_2.FillBox(new ArrayList<>(deliveredContents2));
            // deliveredContents2.clear();
            // System.out.println("<" + tickCount + "> <" + threadId + ">" + " Box: " +
            // box_2);
            // }
            // }
            // });
            // t2.start();
        }

        // synchronized (box_1) {
        //     if (box_1.size() != 0) {
        //         if (assistant1Busy == false) {
        //             synchronized (assistant1) {
        //                 assistant1.takeBooksFromBox(box_1);
        //                 ticksNow = tickCount;
        //                 assistant1Busy = true;
        //                 System.out.println("<" + tickCount + "> <" + threadId + ">" + " Assistant: " + assistant1);
        //             }
        //         }
        //     }
        // }

        // synchronized (box_2) {
        // if (box_2.size() != 0) {
        // if (assistant2Busy == false) {
        // synchronized (assistant2) {
        // assistant2.takeBooksFromBox(box_2);
        // ticksNow = tickCount;
        // assistant2Busy = true;
        // System.out.println("<" + tickCount + "> <" + threadId + ">" + " Assistant: "
        // + assistant2);
        // }
        // }
        // }
        // }

        // if (assistant1Busy == true) {
        // if (tickCount == ticksNow + 10) {
        // for (Books book : assistant1.getBooks()) {
        // if (book.toString().equals("Fiction")) {
        // FictionShelf.add(book);
        // } else if (book.toString().equals("Horror")) {
        // HorrorShelf.add(book);
        // } else if (book.toString().equals("Sport")) {
        // SportShelf.add(book);
        // } else if (book.toString().equals("Fantasy")) {
        // FantasyShelf.add(book);
        // } else if (book.toString().equals("Romance")) {
        // RomanceShelf.add(book);
        // } else if (book.toString().equals("Crime")) {
        // CrimeShelf.add(book);
        // }
        // }
        // }
        // if ( assistant2Busy == true){
        // if (tickCount == ticksNow + 10) {
        // for (Books book : assistant1.getBooks()) {
        // if (book.toString().equals("Fiction")) {
        // FictionShelf.add(book);
        // } else if (book.toString().equals("Horror")) {
        // HorrorShelf.add(book);
        // } else if (book.toString().equals("Sport")) {
        // SportShelf.add(book);
        // } else if (book.toString().equals("Fantasy")) {
        // FantasyShelf.add(book);
        // } else if (book.toString().equals("Romance")) {
        // RomanceShelf.add(book);
        // } else if (book.toString().equals("Crime")) {
        // CrimeShelf.add(book);
        // }
        // }
        // }
        // }
        // if (assistant1Busy == true || assistant2Busy == true)
        // if (!FictionShelf.isEmpty()) {
        // synchronized (FictionShelf) {
        // for (Books book : FictionShelf) {
        // fiction = shelf.StackFictionShelf(book);
        // // try {
        // // Thread.sleep(1000); // 1000 milliseconds = 1 second
        // // } catch (InterruptedException e) {
        // // e.printStackTrace();
        // // }
        // }
        // FictionShelf.clear();
        // System.out.println("Fiction: " + fiction);
        // }
        // }
        // if (!HorrorShelf.isEmpty()) {
        // synchronized (HorrorShelf) {
        // for (Books book : HorrorShelf) {
        // horror = shelf.StackHorrorShelf(book);
        // }
        // HorrorShelf.clear();

        // System.out.println(horror);
        // }

        // }
        // if (!SportShelf.isEmpty()) {
        // synchronized (SportShelf) {
        // for (Books book : SportShelf) {
        // sport = shelf.StackSportShelf(book);
        // }
        // SportShelf.clear();
        // }
        // }
        // if (!FantasyShelf.isEmpty()) {
        // synchronized (FantasyShelf) {
        // for (Books book : FantasyShelf) {
        // fantasy = shelf.StackFantasyShelf(book);
        // }
        // FantasyShelf.clear();

        // }
        // }
        // if (!RomanceShelf.isEmpty()) {
        // synchronized (RomanceShelf) {
        // for (Books book : RomanceShelf) {
        // romance = shelf.StackRomanceShelf(book);
        // }
        // RomanceShelf.clear();

        // }
        // }
        // if (!CrimeShelf.isEmpty()) {
        // synchronized (CrimeShelf) {
        // for (Books book : CrimeShelf) {
        // crime = shelf.StackCrimeShelf(book);
        // }
        // CrimeShelf.clear();

        // }
        // }
        // }

        if (tickCount % 100 == 0 && tickCount < 1000) {
            deliveryTime = delivery.NextDeliveryTime();
            deliveryTime = deliveryTime + tickCount;
            System.out.println(deliveryTime);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            test myThread = new test();
            Thread thread = new Thread(myThread);
            thread.start();
        }
        // Main t2 = new Main();
        // Thread thread1 = new Thread(t1);
        // Thread thread2 = new Thread(t2);
        // thread1.start();
        // thread2.start();
    }
}
synchronized (box_1) {
    List<Books> deliveredContents1 = delivery.GenerateDelivery();
    box_1.FillBox(new ArrayList<>(deliveredContents1));
    deliveredContents1.clear();
    System.out.println("<" + tickCount + "> <" + threadId + ">" + " Box: " + box_1);
}