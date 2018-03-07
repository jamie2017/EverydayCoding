package Tries;

/**
 * Created by JMYE on 11/20/16.
 */

/*
1) Create an empty Trie.  Every node of Trie is going to
   contain two children, for 0 and 1 value of bit.
2) Initialize pre_xor = 0 and insert into the Trie.
3) Initialize result = minus infinite
4) Traverse the given array and do following for every
   array element arr[i].
       a) pre_xor  = pre_xor  ^ arr[i]
          pre_xor now contains xor of elements from
          arr[0] to arr[i].
       b) Query the maximum xor value ending with arr[i]
          from Trie.
       c) Update result if the value obtained in step
          4.b is more than current value of result.

 */


public class MaximumXORofTwoNumbersinanArray {
    /**
     * 计算数组间两数异或的最大值
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        /*前缀树*/
        int res = 0;
        Node root = new Node();
        for (int num : nums) {
            buildTrie(root, num);
        }
        for (int value : nums) {
            int xorValue = findMatchXor(root, value);
            res = Math.max(res, xorValue ^ value);
        }
        return res;
    }

    /**
     * 找到与num匹配的在前缀树中最大的数
     *
     * @param root
     * @param num
     * @return
     */
    private int findMatchXor(Node root, int num) {
        int res = 0;
        Node head = root;
        for (int i = 30; i >= 0; i--) {
            int bit = num & (1 << i);
            int flag = bit == 0 ? 0 : 1;
            /*异或的最大值就是找到与num同等位相反的，这样才是最大值*/
            /*如果不存在这样分支，则找与num同等位相同的*/
            if (head.next[1 - flag] == null) {
                head = head.next[flag];
                /*加*/
                res += flag << i;
            } else {
                head = head.next[1 - flag];
                /*加*/
                res += (1 - flag) << i;
            }
        }
        return res;
    }

    /**
     * 构建前缀树
     *
     * @param root
     * @param x
     */
    private void buildTrie(Node root, int x) {
        /*建前缀树的过程,需要31位 不包括符号位*/
        Node head = root;
        for (int i = 30; i >= 0; i--) {
            int bit = x & (1 << i);/*判断第 i bit位*/
            int flag = bit == 0 ? 0 : 1;
            /*前缀树的基本构建过程，如果没有则添加，有的继续向下*/
            if (head.next[flag] == null) {
                head.next[flag] = new Node();
            }
            head = head.next[flag];
        }
    }

    private static class Node {
        Node[] next;

        public Node() {
            /**0 和 1 */
            next = new Node[2];
        }
    }


    public static void main(String[] args) {
        MaximumXORofTwoNumbersinanArray test = new MaximumXORofTwoNumbersinanArray();
        int[] nums = {8,2,12,7,6};
        System.out.println(test.findMaximumXOR(nums));
    }
}
