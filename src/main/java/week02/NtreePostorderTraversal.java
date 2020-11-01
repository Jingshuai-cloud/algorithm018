package week02;

import java.util.*;

public class NtreePostorderTraversal {

    //recursion time Space O(n)
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> recursion(Node root) {
        if (root == null) return list;
        for (Node node: root.children) {
            recursion(node);
        }
        list.add(root.val);
        return list;

    }

    public List<Integer> stack (Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (Node nodeChild : node.children) {
                stack.push(nodeChild);
            }
        }
        Collections.reverse(list);
        return list;
    }
    public class Node {
        public ArrayList<Node> children;
        private int val;
        public Node(int val){
            this.val = val;
        }
    }

}
