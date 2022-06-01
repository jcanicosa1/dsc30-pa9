/*
 * PID: A16957972
 */

import java.util.*;

public class ContactList {
    ArrayList<Person> people;
	
	// Add instance variables here
	
    public boolean createContact(Person person) {
        if (lookupContact(person.getName())) {
            return false;
        }
        people.add(person);
        return true;
    }

    public boolean lookupContact(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Person getContact(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Person[] getContactByRange(String start, String end) {
        return null;
    }

    public boolean deleteContact(String name) {
        return true;
    }

    public int size() {
        return 42;
    }

    public String[] fetchAllNames() {
        return null;
    }

    public String[] fetchAllPhoneNumbers() {
        return null;
    }
}
