/*
 * PID: A16957972
 */

import java.util.*;

public class ContactList {
    private int size = 0;
    private DoublyLinkedList<Person> people = new DoublyLinkedList<>();
	
	// Add instance variables here
	
    public boolean createContact(Person person) {
        if (lookupContact(person.getName())) {
            return false;
        }
        if (size == 0) {
            people.add(person);
        } else {
            InsertionSort(person);
        }
        size++;
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
        ArrayList<Person> contacts = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (0 < people.get(i).getName().compareTo(start) && 0 > people.get(i).getName().compareTo(end)) {
                contacts.add(people.get(i));
            }
        }

        Person[] peopleArr = new Person[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            peopleArr[i] = contacts.get(i);
        }
        return peopleArr;
    }

    public boolean deleteContact(String name) {
        if (!lookupContact(name)) {
            return false;
        }
        people.remove(getContact(name));
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public String[] fetchAllNames() {
        String[] peopleArr = new String[size()];
        for (int i = 0; i < size(); i++) {
            peopleArr[i] = people.get(i).getName();
        }
        return peopleArr;
    }

    public String[] fetchAllPhoneNumbers() {
        DoublyLinkedList<String> contacts = new DoublyLinkedList<>();
        for (Person p : people) {
            for (String numbers: p.getPhoneNumbers()) {
                if(!contacts.contains(numbers)) {
                    contacts.add(numbers);
                }
            }
        }

        String[] nums = new String[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            nums[i] = contacts.get(i);
        }
        return nums;

    }


}
