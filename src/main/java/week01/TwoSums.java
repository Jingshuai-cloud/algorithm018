package week01;

import java.util.HashMap;

public class TwoSums {
    public static void main(String[] args) {
        int nums[] = {2, 5, 11, 15};
        int target = 17;
        int[] result = twoSumsBruteForce(nums, target);
        int[] result2 = twoSumHashTable(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result2[0]);
        System.out.println(result2[1]);

    }

    private static int[] twoSumsBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }

    private static int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashTable.containsKey(target - nums[i]))
                return new int[] {hashTable.get(target - nums[i]), i};
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
