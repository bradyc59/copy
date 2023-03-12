import java.util.*;

public class Assistant implements Runnable {
    static List<Books> booksToTake = new ArrayList<Books>();
    static List<Books> booksInHands = new ArrayList<Books>();
    private final Object lock = new Object();

    static int carrySpace = 10;
    static boolean isBusy = false;

    public synchronized static List<Books> takeBooksFromBox() {
        List<Books> books = Box.getBooks();
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

    public synchronized boolean isBusy() {
        return isBusy;
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

    @Override
    public void run() {
        while (Main.TICKS_PER_DAY > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // System.out.println(Tick.deliveryRecieved);
            if (Tick.deliveryRecieved == true) {
                if (booksInHands.size() == 0) {
                    booksInHands = takeBooksFromBox();
                }
                if (booksInHands.size() != 0) {
                    synchronized (lock) {
                        Iterator<Books> iterator = booksInHands.iterator();
                        while (iterator.hasNext()) {
                            Books book = iterator.next();
                            if (book.toString().equals("Fiction")) {
                                Shelve.StackFictionShelf(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("Fiction: " + Shelve.FictionShelf);
                                if (!iterator.hasNext()) { // stay at the Fiction shelf until all Fiction books are stacked
                                    try {
                                        Thread.sleep(10000); // simulate 10 seconds to move to the next shelf
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (book.toString().equals("Sport")) {
                                Shelve.StackSportShelf(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("Sport: " + Shelve.SportShelf);
                            } else if (book.toString().equals("Fantasy")) {
                                Shelve.StackFantasyShelf(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("Fantasy: " + Shelve.FantasyShelf);
                            } else if (book.toString().equals("Horror")) {
                                Shelve.StackHorrorShelf(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("Horror: " + Shelve.HorrorShelf);
                            } else if (book.toString().equals("Romance")) {
                                Shelve.StackRomanceShelf(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("Romance: " + Shelve.RomanceShelf);
                            } else if (book.toString().equals("Crime")) {
                                Shelve.StackCrimeShelf(book);
                                iterator.remove(); // remove the book from booksInHands
                                System.out.println("Crime: " + Shelve.CrimeShelf);
                            }
                        }
                    }
                }
                System.out.println(booksInHands);
                // System.out.println("Check books");
                Tick.deliveryRecieved = false;
            }
        }
    }

    public static void main(String[] args) {
        // Box books = new Box();
        // books.main(args);
        // System.out.println(books.toString());
        // takeBooksFromBox(books);
        // System.out.println(books.toString());

        // System.out.println(booksToTake.toString());
        // System.out.println(takeBooksFromBox(books));
    }

    public List<Books> getBooks() {
        return booksToTake;
    }
}
