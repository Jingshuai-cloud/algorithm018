package week01;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSums {
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        List result = threeSumsBruteForce(nums);
        List result2 = threeSumHashTable(nums);
        List result3 = threeSumDoublePonter(nums);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }

    private static List threeSumDoublePonter(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
           while (head < tail) {
               int sum = -(nums[head] + nums[tail]);
                if (nums[i] == sum) {
                    List<Integer> list = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(list);
                }
                if (nums[i] >= sum)
                    tail--;
                else
                    head++;
            }
        }
        return new ArrayList(result);
    }

    private static List<List<Integer>> threeSumHashTable(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -(nums[i]);
            HashMap hashMap = new HashMap();
            for (int j = i + 1; j < nums.length; j++) {
                if (hashMap.containsKey(target - nums[j])) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], target - nums[j]);
                    result.add(list);
                }
                    hashMap.put(nums[j], nums[j]);
            }
        }
        return new ArrayList<>(result);
    }

    private static List<List<Integer>> threeSumsBruteForce(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length -2; i++) {
            for (int j = i + 1; j < nums.length -1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] ==0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(list);
                    }

                }
            }
        }
        return new ArrayList<>(result);
    }

}
