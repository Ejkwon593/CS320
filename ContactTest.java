package contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("001", "John", "Smith", "1234567890", "123 Apple St");
    }

    // ---------------------------
    // Tests to Create Contact
    // ---------------------------

    @Test
    public void testCreateContactWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("002", null, "Smith", "1234567890", "123 Apple St");
        });
    }

    @Test
    public void testCreateContactWithInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("003", "Jane", null, "1234567890", "123 Apple St");
        });
    }

    @Test
    public void testCreateContactWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("004", "Jane", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testCreateContactWithPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("005", "Jane", "Doe", "1234567890123", "123 Apple St");
        });
    }

    @Test
    public void testCreateContactWithPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("006", "Jane", "Doe", "12345", "123 Apple St");
        });
    }

    // ---------------------------
    // Tests to Update Contact
    // ---------------------------

    @Test
    public void testUpdateContactSuccessfully() {
        contact.setFirstName("NewName");
        contact.setLastName("NewLast");
        contact.setPhone("0987654321");
        contact.setAddress("456 Banana Rd");

        assertEquals("NewName", contact.getFirstName());
        assertEquals("NewLast", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Banana Rd", contact.getAddress());
    }

    @Test
    public void testUpdateWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testUpdateWithInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void testUpdateWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    public void testUpdateWithInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    @Test
    public void testUpdateWithPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("1234");
        });
    }

    @Test
    public void testUpdateWithPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123456789012345");
        });
    }
}
