import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContactListTest {

    @Test
    public void createContact() {
        ContactList obj = new ContactList();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("12345");
        boolean check = obj.createContact(new Person("mark", new ArrayList<>()));
    }

    @Test
    public void lookupContact() {
    }

    @Test
    public void getContact() {
    }

    @Test
    public void getContactByRange() {
    }

    @Test
    public void deleteContact() {
    }

    @Test
    public void size() {
    }

    @Test
    public void fetchAllNames() {
    }

    @Test
    public void fetchAllPhoneNumbers() {
    }
}