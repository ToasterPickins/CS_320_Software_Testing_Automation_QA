/*
 * Quintin B. Rozelle
 */

package module6_1;

public class Contact {
	//Fields
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {		
		this.contactID = validateContactID(contactID);
		this.firstName = validateFirstName(firstName);
		this.lastName = validateLastName(lastName);
		this.phone = validatePhone(phone);
		this.address = validateAddress(address);
	}
	
	/*
	 * Accessors and mutators. Mutators will validate input before updating fields
	 */
	
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public void setFirstName(String firstName) {
		this.firstName = validateFirstName(firstName);
	}
	public void setLastName(String lastName) {
		this.lastName = validateLastName(lastName);
	}
	public void setPhone(String phone) {
		this.phone = validatePhone(phone);
	}
	public void setAddress(String address) {
		this.address = validateAddress(address);
	}
	
	/*
	 * Validation methods. All will validate then return validated input for use.
	 * 
	 * All will throw an IllegalArgumentException if input is not valid. In a fully functioning
	 * program, these exceptions would need to be handled (or invalid input dealt with within
	 * the logic of the methods) instead. Though, for testing purposes, throwing an exception
	 * that is checked with JUnit via the assertThrows and assertEquals assertions is
	 * sufficient to prove that input is being validated prior to use.
	 */
	
    /*
     * TODO: The contact object shall have a required unique contact ID string that cannot
     * be longer than 10 characters. The contact ID shall not be null and shall not be
     * updatable.
     * 
     * Uniqueness of the ID is checked in ContactService class upon adding the contact to
     * the contact list.
     * Unable to update ID after contact creation since field is private and no public
     * setter exists.
     */
    private String validateContactID(String contactID) {
    	if (contactID == null) {
			throw new IllegalArgumentException("ERROR: Contact ID cannot be null");
		} else if (contactID.length() > 10){
			throw new IllegalArgumentException("ERROR: Contact ID length cannot be > 10");
		}
		return contactID;
    }
	
	/*
	 * TODO: The contact object shall have a required firstName String field that cannot
	 * be longer than 10 characters. The firstName field shall not be null.
	 */
    private String validateFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("ERROR: First name cannot be null");
		} else if (firstName.length() > 10){
			throw new IllegalArgumentException("ERROR: First name length cannot be > 10");
		} else {
			return firstName;
		}
	}
    
    /*
     * TODO: The contact object shall have a required lastName String field that cannot
     * be longer than 10 characters. The lastName field shall not be null.
     */
    private String validateLastName(String lastName) {
    	if (lastName == null) {
			throw new IllegalArgumentException("ERROR: Last name cannot be null");
		} else if (lastName.length() > 10){
			throw new IllegalArgumentException("ERROR: Last name length cannot be > 10");
		} else {
			return lastName;
		}
    }
    
    /*
     * TODO: The contact object shall have a required phone String field that must be
     * exactly 10 digits. The phone field shall not be null.
     */
    private String validatePhone(String phone) {
    	if (phone == null) {
			throw new IllegalArgumentException("ERROR: Phone cannot be null");
		} else if (phone.length() != 10){
			throw new IllegalArgumentException("ERROR: Phone length must be 10");
		} else {
			return phone;
		}
    }
    
    /*
     * TODO: The contact object shall have a required address field that must be no
     * longer than 30 characters. The address field shall not be null.
     */
    private String validateAddress(String address) {
    	if (address == null) {
			throw new IllegalArgumentException("ERROR: Address cannot be null");
		} else if (address.length() > 30){
			throw new IllegalArgumentException("ERROR: Address length cannot be > 30");
		} else {
			return address;
		}
    }

}
