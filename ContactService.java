/*
 * Quintin B. Rozelle
 */

package module6_1;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	//Fields
	private Map<String, Contact> contactMap = new HashMap<String, Contact>();
	
	/*
	 * Methods. All will return true if successful. False otherwise.
	 */
	
	/*
	 * TODO The contact service shall be able to add contacts with a unique ID.
	 * 
	 * Uniqueness of contact ID is checked here prior to adding
	 */
	public boolean addContact(Contact contact) {
		if (contactMap.containsKey(contact.getContactID())) {
			System.out.println("ContactID already present");
			return false;
		} else {
			contactMap.put(contact.getContactID(), contact);
			return true;
		}
	}
	
    /*
     * TODO The contact service shall be able to delete contacts per contact ID.
     */
	public boolean deleteContact(String contactID) {
		if (contactMap.containsKey(contactID)) {
			contactMap.remove(contactID);
			System.out.println("Contact removed");
			return true;
		} else {
			System.out.println("Contact ID not found. Unable to remove");
			return false;
		}
	}
	
    /*
     * TODO The contact service shall be able to update contact fields per contact ID.
     * The following fields are updatable:
     * 		firstName
     * 		lastName
     * 		Number
     * 		Address
     */
	public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		if (contactMap.containsKey(contactID)) {
			var contact = contactMap.get(contactID);
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setPhone(phone);
			contact.setAddress(address);
			System.out.println("Contact Updated");
			return true;
		} else {
			System.out.println("Contact not found. Unable to update");
			return false;
		}
	}
	
	public boolean updateContactFirstName(String contactID, String firstName) {
		if (contactMap.containsKey(contactID)) {
			contactMap.get(contactID).setFirstName(firstName);
			System.out.println("Contact Updated");
			return true;
		} else {
			System.out.println("Contact not found. Unable to update");
			return false;
		}
	}
	
	public boolean updateContactLastName(String contactID, String lastName) {
		if (contactMap.containsKey(contactID)) {
			contactMap.get(contactID).setLastName(lastName);
			System.out.println("Contact Updated");
			return true;
		} else {
			System.out.println("Contact not found. Unable to update");
			return false;
		}
	}
	
	public boolean updateContactPhone(String contactID, String phone) {
		if (contactMap.containsKey(contactID)) {
			contactMap.get(contactID).setPhone(phone);
			System.out.println("Contact Updated");
			return true;
		} else {
			System.out.println("Contact not found. Unable to update");
			return false;
		}
	}
	
	public boolean updateContactAddress(String contactID, String address) {
		if (contactMap.containsKey(contactID)) {
			contactMap.get(contactID).setAddress(address);
			System.out.println("Contact Updated");
			return true;
		} else {
			System.out.println("Contact not found. Unable to update");
			return false;
		}
	}

}
