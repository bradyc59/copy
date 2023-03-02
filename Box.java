import java.util.*;

public class Box {
    static int space = 50;

    public List<Books> FillBox(Delivery DeliveryList) {
        int i = 0;
        List<Books> BooksInBox = new ArrayList<Books>();
        
        System.out.print("Yuppppaa");

        while (BooksInBox.size() <= 50) {
            if (DeliveryList.size() != 0) 
            System.out.print("Conor");
            {
                while (i < DeliveryList.size()) 
                {
                    System.out.print("Is");
                    i++;
                }
            }
            System.out.print("A");
        }

        System.out.print("Hero");
        return BooksInBox;
    }

    public static List<Books> CreateNewBox() {
        List<Books> box = (List<Books>) new Box();

        return box;
    }

    public void main(String [] args) 
    {
        List<Books> Box_1 = CreateNewBox();
        Delivery Delivery = new Delivery();
        Box_1 = FillBox(Delivery);
        Delivery Delivery_2 = new Delivery();
        Box_1 = FillBox(Delivery_2);
        Delivery Delivery_3 = new Delivery();
        Box_1 = FillBox(Delivery_3);
        Delivery Delivery_4 = new Delivery();
        Box_1 = FillBox(Delivery_4);
        Delivery Delivery_5 = new Delivery();
        Box_1 = FillBox(Delivery_5);
        Delivery Delivery_6 = new Delivery();
        Box_1 = FillBox(Delivery_6);

        System.out.print(Box_1);
    }

}
