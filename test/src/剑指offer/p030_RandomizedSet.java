package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class p030_RandomizedSet {
    HashMap<Integer,Integer> numToLocation;
    ArrayList<Integer> nums;
    /** Initialize your data structure here. */
    public p030_RandomizedSet() {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numToLocation.containsKey(val)){
            return false;
        }
        numToLocation.put(val,nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)){
            return false;
        }
        int index = numToLocation.get(val);
        numToLocation.put(nums.get(nums.size()-1),index);
        numToLocation.remove(val);
        nums.set(index,nums.get(nums.size()-1));
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}
