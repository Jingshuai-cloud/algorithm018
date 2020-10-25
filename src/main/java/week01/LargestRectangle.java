package week01;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int result = largestRectangleBruteForce(height);
        int result2 = largestRectangleBruteForce2(height);
        int result3  = largestRectangleStack(height);
        System.out.println(result3);
    }

    private static int largestRectangleStack(int[] height) {
        int result = 0;
        Stack<Integer> stack  = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[i] < height[stack.peek()]) {
                int current = height[stack.pop()];
                result = Math.max(result, (i - stack.peek() - 1) * current);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            result = Math.max(result, (height.length - stack.peek() -1) * height[stack.pop()]);
        }
        return result;
    }

    private static int largestRectangleBruteForce2(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int minHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                minHeight = Math.min(minHeight, height[j]);
                result = Math.max(result, minHeight * (j - i + 1));
            }
        }
        return result;
    }

    private static int largestRectangleBruteForce(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                int minHeight = height[i];
                for (int k = i + 1; k <= j; k++) {
                    minHeight = Math.min(minHeight, height[k]);
                }
                result = Math.max(result, minHeight * (j - i + 1));
            }
        }
        return result;
    }
}
