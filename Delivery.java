import java.util.*;

public class Delivery {
    static Object Books = new Books();
    static int size = 10;

    public static List GenerateDelivery() {
        int i = 0;

        List<Books> DeliveryList = new ArrayList<Books>();

        while (i < size) {
            Books book = new Books();
            
            book.setCategory();

            DeliveryList.add(book);

            i++;
        }
        System.out.print(DeliveryList);

        for (int x=0; x < DeliveryList.size(); x++) {
            Books test = DeliveryList.get(x);
            test.Category();
        }

        return DeliveryList;
    }

    public static void main(String[] args) {
        GenerateDelivery();
    }
}
