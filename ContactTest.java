/*
 * Quintin B. Rozelle
 */

package module6_1_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import module6_1.Contact;



class ContactTest {
	
	/*
	 * Confirmation that contact can be created
	 */
	@Test
	void testContactCreation() {
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("First", testContact.getFirstName());
		assertEquals("Last", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhone());
		assertEquals("123 Main", testContact.getAddress());
	}
	
	/*
	 * Confirmation that ID cannot be null and must be 10 or less characters
	 */
	@Test
	void contactIDIsNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact(null, "First", "Last", "1234567890", "123 Main");});
		assertEquals("ERROR: Contact ID cannot be null", exception.getMessage());
	}
	
	@Test
	void contactIDIsTooLong() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("12345678901", "First", "Last", "1234567890", "123 Main");});
		assertEquals("ERROR: Contact ID length cannot be > 10", exception.getMessage());
	}
	
	/*
	 * Confirmation that first name cannot be null and must be 10 or less characters
	 */
	@Test
	void firstNameIsNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000002", null, "Last", "1234567890", "123 Main");});
		assertEquals("ERROR: First name cannot be null", exception.getMessage());
	}
	
	@Test
	void firstNameIsTooLong() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000003", "ReallyLongFirst", "Last", "1234567890", "123 Main");});
		assertEquals("ERROR: First name length cannot be > 10", exception.getMessage());
	}
	
	/*
	 * Confirmation that last name cannot be null and must be 10 or less characters
	 */
	@Test
	void lastNameIsNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000004", "First", null, "1234567890", "123 Main");});
		assertEquals("ERROR: Last name cannot be null", exception.getMessage());
	}
	
	@Test
	void lastNameIsTooLong() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000005", "First", "ReallyLongLastName", "1234567890", "123 Main");});
		assertEquals("ERROR: Last name length cannot be > 10", exception.getMessage());
	}
	
	/*
	 * Confirmation that phone cannot be null and must be 10 characters exactly
	 */
	@Test
	void phoneIsNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000006", "First", "Last", null, "123 Main");});
		assertEquals("ERROR: Phone cannot be null", exception.getMessage());
	}
	
	@Test
	void phoneIsTooShort() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000007", "First", "Last", "123", "123 Main");});
		assertEquals("ERROR: Phone length must be 10", exception.getMessage());
	}
	
	@Test
	void phoneIsTooLong() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000008", "First", "Last", "12345678901234567890", "123 Main");});
		assertEquals("ERROR: Phone length must be 10", exception.getMessage());
	}
	
	/*
	 * Confirmation that address cannot be null and must be 30 or less characters
	 */
	@Test
	void addressIsNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000009", "First", "Last", "1234567890", null);});
		assertEquals("ERROR: Address cannot be null", exception.getMessage());
	}
	
	@Test
	void addressIsTooLong() {
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {new Contact("0000000010", "First", "Last", "1234567890", "1234567890 Really Super Long Address");});
		assertEquals("ERROR: Address length cannot be > 30", exception.getMessage());
	}
	
	/*
	 * Test of setter methods
	 */
	@Test
	void testSetters() {
		Contact testContact = new Contact("00000", "00000", "00000", "0000000000", "00000");
		testContact.setFirstName("First");
		testContact.setLastName("Last");
		testContact.setPhone("1234567890");
		testContact.setAddress("123 Main");
		assertEquals("First", testContact.getFirstName());
		assertEquals("Last", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhone());
		assertEquals("123 Main", testContact.getAddress());
	}
}
