import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class Transaction {
    private static Transaction instance;

    private Transaction() {}
    
    public static Transaction getTransaction() {
        if (instance == null) {
            instance = new Transaction();
        }
        return instance;
    }

    // Methods
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book);
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            return true;
        }
        else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    public boolean returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);

            return true;
        }
        else {
            System.out.println("This book was not borrowed by the member.");
            return false;
        }
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public void saveTransaction(String transaction) {
        // Save transactions to the text file
        try {
            FileWriter fileWriter = new FileWriter("transactions.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(transaction);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void displayTransactionHistory() {
        // Display transactions from the text file
        try {
            File file = new File("transactions.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

