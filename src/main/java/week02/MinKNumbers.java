package week02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinKNumbers {
    public static void main(String[] args) {
        int[] nums = {2,5,6,6,1,7,10};
        int k = 3;
        int[] result = minKNumberPriorityQueue(nums,k);
        for (int i : result) {
            System.out.print(i);
        }
    }

    private static int[] minKNumberPriorityQueue(int[] nums, int k) {
        int res[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i< nums.length; i++) {
            if (pq.peek() > nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return  res;
    }
}
