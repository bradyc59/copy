import java.util.*;

public class Shelve {
    static int capacity = 20;
    static List<Books> FictionShelf = new ArrayList<Books>();
    static List<Books> HorrorShelf = new ArrayList<Books>();
    static List<Books> SportShelf = new ArrayList<Books>();
    static List<Books> FantasyShelf = new ArrayList<Books>();
    static List<Books> RomanceShelf = new ArrayList<Books>();
    static List<Books> CrimeShelf = new ArrayList<Books>();


    public static void AddBooksToShelves(Assistant assistant) {
        for (Books book : assistant.getBooks()) {
            // System.out.println(book.toString().equals("Fiction"));
            // System.out.println(book);
            if (book.toString().equals("Fiction")) {
                if (FictionShelf.size() < capacity) {
                    FictionShelf.add(book);
                }
            } else if (book.toString().equals("Horror")) {
                if (HorrorShelf.size() < capacity) {
                    HorrorShelf.add(book);
                }
            } else if (book.toString().equals("Sport")) {
                if (SportShelf.size() < capacity) {
                    SportShelf.add(book);
                }
            } else if (book.toString().equals("Fantasy")) {
                if (FantasyShelf.size() < capacity) {
                    FantasyShelf.add(book);
                }
            } else if (book.toString().equals("Romance")) {
                if (RomanceShelf.size() < capacity) {
                    RomanceShelf.add(book);
                }
            } else if (book.toString().equals("Crime")) {
                if (CrimeShelf.size() < capacity) {
                    CrimeShelf.add(book);
                }
            }
        }
        // System.out.println(FictionShelf);
        // System.out.println(HorrorShelf);
        // System.out.println(SportShelf);
        // System.out.println(FantasyShelf);
        // System.out.println(RomanceShelf);
        // System.out.println(CrimeShelf);
    }
    
    public static void main(String [] args){
        Assistant assistant = new Assistant();
        assistant.main(args);
        System.out.println(assistant);
        AddBooksToShelves(assistant);
        // System.out.println(FictionShelf);
    }
}
