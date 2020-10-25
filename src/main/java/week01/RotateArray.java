package week01;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        //int[] result = rotateArrayBruteForce(nums, k);
        //int[] result2 = rotateArrayCreateArray(nums, k);
        int[] result3 = rotateArrayCircularSubstitue(nums, k);
        for (int i = 0; i < result3.length; i++) {
            System.out.println(result3[i]);
        }
    }

    private static int[] rotateArrayCircularSubstitue(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(current != start);
        }
        return nums;
    }

    private static int[] rotateArrayCreateArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
    }

    private static int[] rotateArrayBruteForce(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length -1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
        return nums;
    }
}
