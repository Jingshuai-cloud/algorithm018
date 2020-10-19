package week01;

public class MoveZeros {
    public static void main(String[] args) {
        int nums[] = {0,1,2,0,4};
        int result[] = moveZeros2(nums);
        for (int i =0; i <result.length; i++) {
            System.out.print(result[i]);
        }
    }

    private static int[] moveZeros(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    //optimization
    private static int[] moveZeros2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (i > j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = temp;
                }
            }
        }
        return nums;
    }
}
