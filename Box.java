import java.util.*;

public class Box {
    static int space = 50;
    public static List<Books> BooksInBox = new ArrayList<Books>();
    static Box Box_1;


    // Need Function to print contents of Box
    public List<Books> getBooks() {
        List<Books> books = new ArrayList<>();
    
        synchronized (BooksInBox) {
            // Wait until the box has books
            while (BooksInBox.isEmpty()) {
                try {
                    BooksInBox.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    
            // Take up to 10 books from the box
            Iterator<Books> iterator = BooksInBox.iterator();
            int count = 0;
            while (iterator.hasNext() && count < 10) {
                Books book = iterator.next();
                iterator.remove();
                books.add(book);
                count++;
            }
        }
    
        return books;
    }

    public static List<Books> FillBox(List<Books> DeliveryList) {
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

    public int size() {
        int Size = BooksInBox.size();

        System.out.print(Size);

        return Size;
    }

    public static Box CreateNewBox() {
        Box box = new Box();
        // System.out.println(box.getClass());
        return box;
    }

    @Override
    public String toString() {
        return ""+BooksInBox;
    }

    public static void main(String[] args){
        // Box Box_1 = CreateNewBox();
        Delivery Delivery = new Delivery();
        List<Books> delivery_1 = Delivery.GenerateDelivery();
        FillBox(delivery_1);
    }

}
