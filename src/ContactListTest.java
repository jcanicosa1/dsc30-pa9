import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContactListTest {

    @Test
    public void createContact() {
        ContactList obj = new ContactList();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("12345");
        boolean check = obj.createContact(new Person("mark", arr));
        ArrayList<String> arr2 = new ArrayList<>();
        arr.add("2342214");
        obj.createContact(new Person("mar", new ArrayList<>()));
        String[] toPrint = obj.fetchAllNames();
        for (int i = 0; i < toPrint.length; i++) {
            System.out.println(toPrint[i]);
        }
        String[] toPrint1 = obj.fetchAllPhoneNumbers();
        for (int i = 0; i < toPrint1.length; i++) {
            System.out.println(toPrint1[i]);
        }

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