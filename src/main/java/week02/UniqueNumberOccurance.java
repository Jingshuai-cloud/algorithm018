package week02;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOccurance {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,3,2,2};
        boolean result = uniqueOccuranceHashMap(nums);
        System.out.println(result);
    }
    //Time O(n)   Space O(n)
    private static boolean uniqueOccuranceHashMap(int[] nums) {
        HashMap<Integer, Integer> occurance = new HashMap<>();
        for (int num : nums) {
            occurance.put(num, occurance.getOrDefault(num, 0) + 1);
        }
        return occurance.size() == new HashSet<Integer>(occurance.values()).size();
    }
}
