import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContactListTest {

    @Test
    public void createContact() {
        ContactList obj = new ContactList();
        String[] toPrint = obj.fetchAllNames();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("12345");
        boolean check = obj.createContact(new Person("mark", arr));
        toPrint = obj.fetchAllNames();

        ArrayList<String> arr2 = new ArrayList<>();
        arr.add("2342214");
        obj.createContact(new Person("karl", new ArrayList<>()));
        toPrint = obj.fetchAllNames();


        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("23214");
        obj.createContact(new Person("mia", new ArrayList<>()));
        toPrint = obj.fetchAllNames();

        for (int i = 0; i < toPrint.length; i++) {
            System.out.println(toPrint[i]);
        }
        /*
        String[] toPrint1 = obj.fetchAllPhoneNumbers();
        for (int i = 0; i < toPrint1.length; i++) {
            System.out.println(toPrint1[i]);
        }

         */

    }

    @Test
    public void lookupContact() {
    }

    @Test
    public void getContact() {
    }

    @Test
    public void getContactByRange() {

        ContactList obj = new ContactList();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("12345");
        boolean check = obj.createContact(new Person("mark", arr));
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("2342214");
        obj.createContact(new Person("karl", new ArrayList<>()));
        String[] toPrint = obj.fetchAllNames();
        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("23214");
        obj.createContact(new Person("mia", new ArrayList<>()));
        Person[] grr = obj.getContactByRange("karl", "mia");
        String[] toPrint2 = obj.fetchAllNames();


        for (Person o: grr) {
            System.out.println(o.getName());
        }




        /*
        ContactList obj2 = new ContactList();
        ArrayList<String> arr0 = new ArrayList<>();
        arr0.add("12345");
        obj2.createContact(new Person("a", arr0));
        ArrayList<String> arr22 = new ArrayList<>();
        arr22.add("2342214");
        obj2.createContact(new Person("c", arr22));
        String[] toPrint1 = obj2.fetchAllNames();
        ArrayList<String> arr32 = new ArrayList<>();
        arr32.add("23214");
        obj2.createContact(new Person("b", arr32));
        Person[] grr1 = obj2.getContactByRange("a", "c");
        String[] toPrint3 = obj2.fetchAllNames();


        for (Person o: grr1) {
            System.out.println(o.getName());
        }


         */

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
        ContactList obj = new ContactList();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("12345");
        arr.add("12345");
        boolean check = obj.createContact(new Person("mark", arr));
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("2342214");
        arr2.add("234214");
        obj.createContact(new Person("karl", arr2));
        String[] toPrint = obj.fetchAllNames();
        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("23214");
        arr3.add("402752");
        obj.createContact(new Person("mia", arr3));
        String[] o = obj.fetchAllPhoneNumbers();

    }
}