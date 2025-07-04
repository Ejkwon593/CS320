/*
 * Name: Eddy Kwon
 * Course: CS-320
 * Date: May 23, 2024
 * Description: This class manages a collection of Contact objects using in-memory storage.
 */
package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact ID already exists");
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact ID not found");
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String newFirstName) {
        contacts.get(contactId).setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        contacts.get(contactId).setLastName(newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        contacts.get(contactId).setPhone(newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        contacts.get(contactId).setAddress(newAddress);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
