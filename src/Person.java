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
        pnArray.add(pn);
        return true;
    }


    private int getSize() {
        return pnArray.size();
    }

    public ArrayList<String> getPhoneNumbers() {
        QuickSort(this.pnArray, 0, getSize() - 1);
        return this.pnArray;
    }

    public void QuickSort(ArrayList<String> list, int start, int end) {
        // if this is true, the list is already sorted
        if (start >= end) {
            return;
        }
        // when calling the helper function, the end of the low index is returned
        int lowEnd = partition(list, start, end);

        // this method is recursively and will end once it is sorted
        QuickSort(list, start, lowEnd);
        QuickSort(list, lowEnd + 1, end);
    }

    /**
     * partition helper function for QuickSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param h right-most index we want to merge
     */
    private int partition(ArrayList<String> arr, int l, int h) {
        int midpoint = l + (h - l) / 2;
        String pivot = arr.get(midpoint);
        String temp; // temporary value used for swapping
        // sets pivot to the middle element

        boolean check = false;
        while (!check) {
            // looks for the number that is >= pivot
            while (0 > arr.get(l).compareTo(pivot)) {
                l++;
            }

            // searches for the value that is >= pivot from the high index
            while (0 < arr.get(h).compareTo(pivot)) {
                h--;
            }

            // if no elements or only one element is left, then the list is done
            if (l >= h) {
                check = true;
            } else {
                // swaps values
                temp = arr.get(l);
                arr.set(l, arr.get(h));
                arr.set(h, temp);

                // updates the indexes
                l++;
                h--;
            }
        }
        return h;
    }

    public boolean deletePhoneNumber(String pn) {
        if (!pnArray.contains(pn)) {
            return false;
        }
        if (getSize() == 1) {
            throw new IllegalArgumentException();
        }
        pnArray.remove(pn);
        return true;

    }
}
