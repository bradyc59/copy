import java.util.*;

public class Box {
    static int space = 50;
    public List<Books> BooksInBox = new ArrayList<Books>();


    // Need Function to print contents of Box

    public List<Books> FillBox(List<Books> DeliveryList) {
        int i = 0;

            if (DeliveryList.size() != 0) 
            {
                while (i < DeliveryList.size()) 
                {
                    Books x = DeliveryList.get(i);
                    
                    BooksInBox.add(x);
                    
                    i++;
                }
            }

        return BooksInBox;
    }

    public static Box CreateNewBox() {
        Box box = new Box();

        return box;
    }

    public static void main(String [] args) 
    {
        Box Box_1 = CreateNewBox();
        Delivery Delivery = new Delivery();

        Box_1.FillBox(Delivery.GenerateDelivery());

    }

}
