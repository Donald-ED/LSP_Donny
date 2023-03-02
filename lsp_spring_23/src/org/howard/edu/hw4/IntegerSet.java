package org.howard.edu.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class IntegerSet {

    private List<Integer> arr;
    
    /**
     * Default Constructor
     */
    public IntegerSet() {
    	arr = new ArrayList<Integer>();
    }
    
    /**
     *  Clears the internal representation of the set
     */
    public void clear() {
        arr.clear();
    }

    /**
     *  Returns the length of the set
     * @return integer
     */
    public int length() {
        return arr.size();
    }
 
    /**
    * Returns true if the 2 sets are equal, false otherwise;
    * Two sets are equal if they contain all of the same values in ANY order.
    * @param set An IntegerSet Type
    * @return Boolean
    */
    public boolean equals(IntegerSet set2) {
        if (arr.size() != set2.length()) {
            return false;
        }
        for (int item : set2.arr) {
            if (!arr.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  Returns true if the set contains the value, otherwise false
     * @param value Integer
     * @return Boolean
     */
    public boolean contains(int value) {
        return arr.contains(value);
    }

    /**
     *  Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
     * @return Integer
     * @throws Exception
     */
    public int largest() throws Exception {
        if (arr.isEmpty()) {
            throw new Exception("Set is empty");
        }
        return Collections.max(arr);
    }

    /**
     *  Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
     * @return Integer
     * @throws Exception
     */
    public int smallest() throws Exception {
        if (arr.isEmpty()) {
            throw new Exception("Set is empty");
        }
        return Collections.min(arr);
    }

    /**
     *  Adds an item to the set or does nothing it already there	
     * @param item An integer
     */
    public void add(int item) {
        if (!arr.contains(item)) {
            arr.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not there
     * @param item An integer
     */
    public void remove(int item) {
        arr.remove(Integer.valueOf(item));
    }

    /**
     *  Set union
     * @param set2
     */
    public void union(IntegerSet set2) {
        for (int item : set2.arr) {
            if (!arr.contains(item)) {
                arr.add(item);
            }
        }
    }

    /**
     *  Set intersection
     * @param set2 An IntegerSet Type
     */
    public void intersect(IntegerSet set2) {
        arr.retainAll(set2.arr);
    }

    /**
     *  Set difference, i.e., s1 –s2
     * @param set2 An IntegerSet Type
     */
    public void diff(IntegerSet set2) {
        arr.removeAll(set2.arr);
    }

    /**
     * Returns true if the set is empty, false otherwise
     * @return Boolean
     */
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    /**
     *  Return String representation of your set
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (i != arr.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
