package week01;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1,2,3,0,2,4,6};
        int[] result = slidingWindowBruteForce(nums, k);
        int[] result2 = slidingWindowDeque(nums, k);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }
    }

    private static int[] slidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int r = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peekFirst() <= i - k){
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                result[r++] = nums[q.peekFirst()];
            }

        }
        return result;
    }

    private static int[] slidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return  result;
    }
}
