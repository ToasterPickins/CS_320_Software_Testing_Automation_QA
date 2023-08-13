/*
 * Quintin B. Rozelle
 */

package module6_1_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import module6_1.Contact;
import module6_1.ContactService;



class ContactServiceTest {

	/*
	 * Confirmation that 2 unique contacts can be added
	 */
	@Test
	void addContactsWithUniqueIDs() {
		ContactService testContactService = new ContactService();
		Contact testContact1 = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		Contact testContact2 = new Contact("0987654321", "Given", "Surname", "0987654321", "321 Second");
		assertEquals(true, testContactService.addContact(testContact1));
		assertEquals(true, testContactService.addContact(testContact2));
	}
	
	/*
	 * Confirmation that 2 contacts with same ID cannot be added
	 */
	@Test
	void addContactsWithNonUniqueIDs() {
		ContactService testContactService = new ContactService();
		Contact testContact1 = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		Contact testContact2 = new Contact("1234567890", "Given", "Surname", "0987654321", "321 Second");
		assertEquals(true, testContactService.addContact(testContact1));
		assertEquals(false, testContactService.addContact(testContact2));
	}
	
	/*
	 * Confirmation that contacts can be deleted
	 */
	@Test
	void deleteContacts() {
		ContactService testContactService = new ContactService();
		Contact testContact1 = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		Contact testContact2 = new Contact("0987654321", "Given", "Surname", "0987654321", "321 Second");
		testContactService.addContact(testContact1);
		testContactService.addContact(testContact2);
		assertEquals(true, testContactService.deleteContact("1234567890"));
		assertEquals(true, testContactService.deleteContact("0987654321"));
	}
	
	/*
	 * Confirmation that nothing happens if deleting non-existant ID
	 */
	@Test
	void deleteNonExistantContact() {
		ContactService testContactService = new ContactService();
		Contact testContact1 = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		Contact testContact2 = new Contact("0987654321", "Given", "Surname", "0987654321", "321 Second");
		testContactService.addContact(testContact1);
		testContactService.addContact(testContact2);
		assertEquals(true, testContactService.deleteContact("1234567890"));
		assertEquals(true, testContactService.deleteContact("0987654321"));
		assertEquals(false, testContactService.deleteContact("0987654321"));
	}
	
	/*
	 * Confirmation that contact can be updated
	 */
	@Test
	void updateContact() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(true, testContactService.updateContact("1234567890", "Given", "Surname", "0987654321", "321 Second"));
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("Given", testContact.getFirstName());
		assertEquals("Surname", testContact.getLastName());
		assertEquals("0987654321", testContact.getPhone());
		assertEquals("321 Second", testContact.getAddress());
	}
	
	@Test
	void updateContactFirstName() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(true, testContactService.updateContactFirstName("1234567890", "Given"));
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("Given", testContact.getFirstName());
		assertEquals("Last", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhone());
		assertEquals("123 Main", testContact.getAddress());
	}
	
	@Test
	void updateContactLastName() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(true, testContactService.updateContactLastName("1234567890", "Surname"));
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("First", testContact.getFirstName());
		assertEquals("Surname", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhone());
		assertEquals("123 Main", testContact.getAddress());
	}
	
	@Test
	void updateContactPhone() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(true, testContactService.updateContactPhone("1234567890", "0987654321"));
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("First", testContact.getFirstName());
		assertEquals("Last", testContact.getLastName());
		assertEquals("0987654321", testContact.getPhone());
		assertEquals("123 Main", testContact.getAddress());
	}
	
	@Test
	void updateContactAddress() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(true, testContactService.updateContactAddress("1234567890", "321 Second"));
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("First", testContact.getFirstName());
		assertEquals("Last", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhone());
		assertEquals("321 Second", testContact.getAddress());
	}
	
	/*
	 * Confirmation that contact not updated if using different ID
	 */
	@Test
	void updateNonExistantContact() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(false, testContactService.updateContact("0987654321", "Given", "Surname", "0987654321", "321 Second"));
	}
	
	@Test
	void updateNonExistantContactFirstName() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(false, testContactService.updateContactFirstName("0987654321", "Given"));
	}
	
	@Test
	void updateNonExistantContactLastName() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(false, testContactService.updateContactLastName("0987654321", "Surname"));
	}
	
	@Test
	void updateNonExistantContactPhone() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(false, testContactService.updateContactPhone("0987654321", "0987654321"));
	}
	
	@Test
	void updateNonExistantContactAddress() {
		ContactService testContactService = new ContactService();
		Contact testContact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main");
		testContactService.addContact(testContact);
		assertEquals(false, testContactService.updateContactAddress("0987654321", "321 Second"));
	}

}
