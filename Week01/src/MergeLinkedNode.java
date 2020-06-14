import java.util.List;

/**
 * Number 21 Leetcode Porblem [Easy]
 */

public class MergeLinkedNode {

    /**
     * Comments:
     * (1) The method I think of is to iterate through the two single Linked List, comparing each element
     *      put in the right order. Notice, it is easier to give a sentinel then it is easier to return
     *      the result.
     * (2) Next time, when there is the iteration, we should also think about if there is any possibility
     *      that we can use the recursion (Because, the recursion is very easy to write the code!). Find
     *      the closest duplicated problem!
     * (3) Boundary conditions are always important to consider with. [null!!]
     * (4) Recursion is faster than the iterative method!
     */

    // officially defined inner class
    public class ListNode {
      int val;
      ListNode next;

      // the corresponding constructor
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * The iterative method
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // create the sentinel
        ListNode sentinel = new ListNode(-28);
        ListNode prev = sentinel;

        // iteration
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // move the prev
            prev = prev.next;
        }

        // boundary condition
        // at most we will have one of the list is null
        prev.next = (l1 == null ? l2 : l1);

        // sentinel point to the head of the linked list
        // or we can say sentinel is the prenode of the head.
        return sentinel.next;
    }

    /**
     * The recursive method
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        // Boundary cases
        if (l1 == null) {
            return  l2;
        }

        if (l2 == null) {
            return  l1;
        }

        // recursion part
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
