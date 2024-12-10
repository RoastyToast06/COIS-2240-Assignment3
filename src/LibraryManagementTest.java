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
	

}
