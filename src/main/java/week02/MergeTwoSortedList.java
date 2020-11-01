package week02;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        MergeTwoSortedList merge = new MergeTwoSortedList();
        merge.createTwoList();
        ListNode l1 = merge.l1;
        ListNode l2 = merge.l2;

        ListNode result =  mergeTwoListRecursion(l1, l2);
        ListNode result2 = mergeTwoListQueue(l1, l2);
        //System.out.println(result);
        System.out.println(result2);
    }
    //Time O(N+M) SpaceO(1)
    private static ListNode mergeTwoListQueue(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        return prevHead.next;
    }

    //Time O(N+M) SpaceO(N+M)
    private static ListNode mergeTwoListRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListRecursion(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListRecursion(l1, l2.next);
            return l2;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

    }
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(1);
    public void createTwoList() {
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        two.next = three;
        l1.next = two;

        four.next = five;
        l2.next = four;

    }
}
