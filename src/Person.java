import java.util.*;   

public class Person {
    private String name;
    private ArrayList<String> pnArray;
	
    // Add instance variables here
	
	public Person(String name, ArrayList<String> pnArray) {
        this.name = name;
        this.pnArray = pnArray;
	}
	
    public String getName() {
        return name;
    }

    public boolean addPhoneNumber(String pn) {
        if (pnArray.contains(pn)) {
            return false;
        }
        InsertionSort(pn);
        return true;
    }

    private void InsertionSort(String toInsert) {
        int start = 0;
        int end = getSize();
        for (int i = start; i < end; i++) {
            if (0 > (toInsert.compareTo(pnArray.get(i)))) {
                pnArray.add(i, toInsert);
                break;
            }
        }
        if (end == getSize()) {
            pnArray.add(toInsert);
        }
    }

    private int getSize() {
        return pnArray.size();
    }

    public ArrayList<String> getPhoneNumbers() {
        return this.pnArray;
    }

    public boolean deletePhoneNumber(String pn) {
        if (getSize() == 1) {
            throw new IllegalArgumentException();
        }

        if (pnArray.contains(pn)) {
            pnArray.remove(pn);
            return true;
        }
        return false;
    }
}
