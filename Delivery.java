import java.util.*;
import java.security.SecureRandom;

public class Delivery {
    static Object Books = new Books();
    static int size = 10;
    public static List<Books> DeliveryList = new ArrayList<Books>();

    public static List<Books> GenerateDelivery() {
        int i = 0;


        while (i < size) {
            Books book = new Books();
            
            book.setCategory();

            DeliveryList.add(book);

            i++;
        }

        // Used for Testing ....  System.out.print(DeliveryList);

        return DeliveryList;
    }

    public int size() {
        int Size = DeliveryList.size();

        System.out.print(Size);

        return Size;
    }

    public static int NextDeliveryTime() {
        SecureRandom rand = new SecureRandom();

        int TicksTillDelivery = rand.nextInt(100);

        if (TicksTillDelivery == 0 ) {
            TicksTillDelivery = 100;
        }
        return TicksTillDelivery;
    }

    @Override
    public String toString() {
        return ""+DeliveryList;
    }

    public static void main(String[] args) {
        GenerateDelivery();
    }


}
