/*
 * PID: A16957972
 */

import java.util.*;

public class ContactList {
    ArrayList<Person> people = new ArrayList<>();
    int size;
	
	// Add instance variables here
	
    public boolean createContact(Person person) {
        if (lookupContact(person.getName())) {
            return false;
        }
        size++;
        InsertionSort(person);
        return true;
    }

    private void InsertionSort(Person toInsert) {
        int start = 0;
        int end = size();
        for (int i = start; i < end; i++) {
            if (0 > (toInsert.getName().compareTo(people.get(i).getName()))) {
                people.add(i, toInsert);
                break;
            }
        }
        if (end == size()) {
            people.add(toInsert);
        }
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
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < size(); i++) {
            if (0 < people.get(i).getName().compareTo(start)) {
                startIndex = i;
                break;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (0 < people.get(i).getName().compareTo(end)) {
                endIndex = i;
                break;
            }
        }
        Person[] peopleArr = new Person[endIndex-startIndex];
        int count = 0;
        for (int i = startIndex; i < endIndex; i++) {
            peopleArr[count] = people.get(i);
            count++;
        }
        return peopleArr;
    }

    public boolean deleteContact(String name) {
        if (!lookupContact(name)) {
            return false;
        }
        people.remove(name);
        return true;
    }

    public int size() {
        return size;
    }

    public String[] fetchAllNames() {
        String[] peopleArr = new String[size() - 1];
        for (int i = 0; i < size(); i++) {
            peopleArr[i] = people.get(i).getName();
        }
        return peopleArr;
    }

    public String[] fetchAllPhoneNumbers() {
        return null;
    }
}
