public class Customer implements Runnable {
    private final String[] genres = {"fiction", "horror", "romance", "fantasy", "poetry", "history"};
    private final Bookstore bookstore;
    private final Random random;
    
    public Customer(Bookstore bookstore) {
        this.bookstore = bookstore;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String genre = genres[random.nextInt(genres.length)];
                if (bookstore.hasBook(genre)) {
                    Book book = bookstore.takeBook(genre);
                    System.out.println("Customer bought " + book + " from " + genre + " section.");
                } else {
                    System.out.println("Customer waiting for " + genre + " book to become available.");
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Customer thread interrupted.");
        }
    }
}