package HighFrequency.TopK.FollowUps;


import java.util.Stack;

/**
 * Created by JMYE on 11/26/16.
 */



public class AddTwoNumberII {
    // follow up of AddTwoNumber

    /*
    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7

    7243
   + 564
   =7807
   Can't not modify input list
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = stackList(l1);
        Stack<Integer> stack2 = stackList(l2);
        ListNode l12 = new ListNode(0);
        int nodeSum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()) nodeSum += stack1.pop();
            if(!stack2.isEmpty()) nodeSum += stack2.pop();
            l12.val = nodeSum % 10;
            ListNode newHead = new ListNode(nodeSum / 10); // will cause zero if nodeSum < 10
            newHead.next = l12;
            l12 = newHead;
            nodeSum /= 10;
        }
        return l12.val == 0 ? l12.next:l12; // because nodeSum/10 will cause zero head value
    }

    private Stack<Integer> stackList(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    // follow up of Add One

    /*
  // Go to the last one, if == 9, then put 0 and remember a carry
  // Remember the node before the last 9 in front of the end node.
  // ==> Remeber last node not 9!
  // Corner case: head should also be modified and add a new node as a head.

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0); // start with 0. If need to update dummy, then check if dummy is modified to 1
        dummy.next = head;
        ListNode cur = dummy, lastnot9 = null;

        while(cur != null){
            if(cur.val != 9){
                lastnot9 = cur;
            }
            cur = cur.next;
        }

        lastnot9.val += 1;
        cur = lastnot9.next;
        while(cur != null){
            cur.val = 0;
            cur = cur.next;
        }
        if(dummy.val == 1) return dummy;
        return dummy.next;
    }
 // This is the lastNot9 solution for add two numbers II. Thanks to the swap trick provided by this post.

 // Carry is at most 1.
 // If the current node is 9, even if there is a carry, the previous node may get affected.
 // If the current node is not 9, even if there is a carry after this, the previous node will not get affected.


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1), len2 = getLength(l2);
        if(len1 < len2){ // swap l1 and l2 to make sure l1 is the longer one
            ListNode tmp = l1; l1 = l2; l2 = tmp;
        }
        int diff = Math.abs(len1-len2);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode lastnot9node = dummy;

        while(diff > 0){
            // create new node
            tail.next = new ListNode(l1.val);

            // update lastnot9node
            if(l1.val != 9) lastnot9node = tail.next;

            // update tails
            tail = tail.next;
            l1 = l1.next;
            diff--;
        }

        while(l1 != null){
            int val = l1.val + l2.val;

            if(val >= 10){
                val -= 10;
                // update previous nodes
                lastnot9node.val++;
                lastnot9node = lastnot9node.next;
                while(lastnot9node != null){
                    lastnot9node.val = 0;
                    lastnot9node = lastnot9node.next;
                }
                lastnot9node = tail;
            }

            // create new node
            tail.next = new ListNode(val);

            // update lastnot9node
            if(val != 9) lastnot9node = tail.next;

            // update tails
            tail = tail.next;
            l1   = l1.next;
            l2   = l2.next;
        }

        if(dummy.val == 1) return dummy;
        return dummy.next;
    }

    private int getLength(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
     */
}
