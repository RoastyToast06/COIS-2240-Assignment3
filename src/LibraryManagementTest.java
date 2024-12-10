import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LibraryManagementTest {

	@Test
	public void testBookID() {
		// Valid IDs
		try {
			Book b1 = new Book(100, "Cake");
			assertEquals(100, b1.getId());
			
			Book b2 = new Book(999, "Frosting");
			assertEquals(999, b2.getId());
			
		} catch (Exception e) {
			fail("These two books are valid, no exceptions should be thrown.");
		}
		
		//Invalid IDs
		try {
			Book b3 = new Book(1000, "Sprinkles");
			fail("Exception should be thrown for this book.");
		} catch (Exception e) {
			assertEquals("Invalid ID.", e.getMessage());
		}
		
		try {
			Book b4 = new Book(99, "Chocolate");
			fail("Exception should be thrown for this book.");
		} catch (Exception e) {
			assertEquals("Invalid ID.", e.getMessage());
		}
		
		try {
			Book b5 = new Book(2240, "Strawberry");
			fail("Exception should be thrown for this book.");
		} catch (Exception e) {
			assertEquals("Invalid ID.", e.getMessage());
		}
	}

	@Test
	public void testBorrowReturn() throws Exception {
		Book b1 = new Book(100, "Cake");
		Member m1 = new Member(6, "Aiden");

		assertTrue(b1.isAvailable());

		// Borrowing the book
		Transaction t1 = Transaction.getTransaction();
		assertTrue(t1.borrowBook(b1, m1));
		assertFalse(b1.isAvailable());
		assertFalse(t1.borrowBook(b1, m1));

		// Returning the book
		assertTrue(t1.returnBook(b1, m1));
		assertTrue(b1.isAvailable());
		assertFalse(t1.returnBook(b1, m1));
	}
	

}
