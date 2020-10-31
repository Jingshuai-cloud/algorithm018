package week02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4};
        int k = 3;
        int[] result = topKelementHeep(nums, k);
        for (int i : result){
            System.out.print(i);
        }
    }

    private static int[] topKelementHeep(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int key = entry.getKey(); int count = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < count) {
                    pq.poll();
                    pq.add(new int[] {key, count});
                }
            }else {
                pq.add(new int[]{key, count});
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
