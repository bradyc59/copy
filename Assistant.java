import java.util.*;

public class Assistant {
    static List<Books> booksToTake = new ArrayList<Books>();
    static int carrySpace = 10;

    public synchronized static List<Books> takeBooksFromBox(Box box) {
        List<Books> books = box.getBooks();
        if (!books.isEmpty()) {
            while (booksToTake.size() < carrySpace) {
                for (Books book : books) {
                    booksToTake.add(book);
                }
            }
            books.removeAll(booksToTake);
            return booksToTake;
        } else {
            return null;
        }
    }

    public int size() {
        int Size = booksToTake.size();

        // System.out.print(Size);

        return Size;
    }

    @Override
    public String toString() {
        return "" + booksToTake;
    }

    public static void main(String[] args) {
        Box books = new Box();
        books.main(args);
        // System.out.println(books.toString());
        takeBooksFromBox(books);
        // System.out.println(books.toString());

        // System.out.println(booksToTake.toString());
        // System.out.println(takeBooksFromBox(books));
    }

    public List<Books> getBooks() {
        return booksToTake;
    }
}
