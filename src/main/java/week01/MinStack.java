package week01;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

   public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, stack.peek()));
   }

   public void pop() {
        stack.pop();
        minStack.pop();
   }

   public int top() {
        return stack.peek();
   }

   public int getMin() {
        return minStack.peek();
   }
}
