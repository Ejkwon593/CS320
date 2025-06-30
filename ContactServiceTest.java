/*
 * Name: Eddy Kwon
 * Course: CS-320
 * Date: May 23, 2024
 * Description: This class tests the ContactService class using JUnit 5.
 */
package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
        service.addContact(new Contact("001", "Alice", "Smith", "1234567890", "Park Ave"));
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("002", "Bob", "Lee", "1112223333", "Elm Street");
        service.addContact(contact);
        assertEquals("Bob", service.getContact("002").getFirstName());
    }

    @Test
    public void testDeleteContact() {
        service.deleteContact("001");
        assertNull(service.getContact("001"));
    }

    @Test
    public void testUpdateAddress() {
        service.updateAddress("001", "New Address St");
        assertEquals("New Address St", service.getContact("001").getAddress());
    }

    @Test
    public void testDuplicateContactIdThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(new Contact("001", "Dan", "Smith", "5555555555", "Dup Lane"));
        });
    }
}
