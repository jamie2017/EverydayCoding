package Editorial_1;

import Tree.TreeNode;
import javafx.util.Pair;

import java.util.*;
import LinkedList.ListNode;

/**
 * Created by jianmei on 7/28/16.
 */
public class Editorial_Solution {
    /*
   // 278 First Bad Version >> Binaray Search O(log n)
//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

   // 1. Two Sum >> Array HashTable one time pass
   //public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++ ) {
          Integer position = map.get(target - nums[i]);
          if (position == null) {
              map.put(nums[i],i);
          } else {
              return new int[]{position,i};
          }
      }
      return null;
  }
   //public int[] twoSumV2(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           int complement = target - nums[i];
           if (map.containsKey(complement)) {
               return new int[] { map.get(complement), i };
           }
           map.put(nums[i], i);
       }
       throw new IllegalArgumentException("No two sum solution");
   }

   // 307. Range Sum Query - Mutable https://leetcode.com/problems/range-sum-query-mutable/
   // Approach #1 Sqrt decomposition
   private class NumArray{
       private int[] b;
       private  int len;
       private  int[] nums;

       public NumArray(int[] nums) {
           this.nums = nums;
           double l = Math.sqrt(nums.length);
           len = (int) Math.ceil(nums.length/l);
           b = new int[len];
           for (int i = 0; i < nums.length; i++) b[i / len] += nums[i];
       }
       public int sumRange(int i, int j) {
           int sum = 0;
           int startBlock = i / len;
           int endBlock = j / len;
           if (startBlock == endBlock) {
               for (int k = i; k <= j; k++)
                   sum += nums[k];
           } else {
               for (int k = i; k <= (startBlock + 1) * len - 1; k++)
                   sum += nums[k];
               for (int k = startBlock + 1; k <= endBlock - 1; k ++)
                   sum += b[k];
               for (int k = endBlock*len; k <=j; k++)
                   sum += nums[k];
           }
           return sum;
       }
       public void update(int i, int val) {
           int b_l = i / len;
           b[b_l] = b[b_l] - nums[i] + val;
           nums[i] = val;
       }
   }
   // Approach # 2 Segmented Tree | Indexed Tree >> To be complete

   // 322. Coin Change
   public int coinChange_bt(int[] coins, int amount) { // TLE backtracking
       return coinChange_bt(0,coins,amount);
   }
   private int coinChange_bt(int idxCoin, int[] coins, int amount) {
       if (amount == 0)
           return 0;
       if (idxCoin < coins.length && amount > 0) {
           int maxVal = amount/coins[idxCoin];
           int minCost = Integer.MAX_VALUE;
           for (int x = 0; x <= maxVal; x++) {
               if (amount >= x * coins[idxCoin]) {
                   int res = coinChange_bt(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                   if (res != -1)
                       minCost = Math.min(minCost, res + x);
               }
           }
           return (minCost == Integer.MAX_VALUE)? -1: minCost;
       }
       return -1;
   }

   public int coinChange_td(int[] coins, int amount) { // Top down
       if (amount < 1) return 0;
       return coinChange_td(coins, amount, new int[amount]);
   }

   private int coinChange_td(int[] coins, int rem, int[] count) {
       if (rem < 0) return -1;
       if (rem == 0) return 0;
       if (count[rem - 1] != 0) return count[rem - 1];
       int min = Integer.MAX_VALUE;
       for (int coin : coins) {
           int res = coinChange_td(coins, rem - coin, count);
           if (res >= 0 && res < min)
               min = 1 + res;
       }
       count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
       return count[rem - 1];
   }

   public int coinChange_bu(int[] coins, int amount) {// Botton up
       int max = amount + 1;
       int[] dp = new int[amount + 1];
       Arrays.fill(dp, max);
       dp[0] = 0;
       for (int i = 1; i <= amount; i++) {
           for (int j = 0; j < coins.length; j++) {
               if (coins[j] <= i) {
                   dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
               }
           }
       }
       return dp[amount] > amount ? -1 : dp[amount];
   }

   // 344. Reverse String
   public static String reverseString0(String s) {
    String result = "";
    char[] ch = s.toCharArray();
    for (int i = ch.length - 1; i >= 0; i--) {
        result += ch[i];
    }
    return result;
}

   public static String reverseString1(String s) {
        String result = "";
        for (int i = s.length() - 1; i >=0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

   public static String reverseString2(String s) {
        return new StringBuffer(s).reverse().toString();
    }

   public static String reverseString3(String s) {
        char[] ch = s.toCharArray();
        int halfLength = s.length() / 2;
        char tmp;
        for (int i = 0; i < halfLength; i++) {
            tmp = ch[s.length() - 1 - i];
            ch[s.length() - 1 - i] = ch[i];
            ch[i] = tmp;
        }
        return new String(ch);
    }
   public static String reverseString5(String s) { //!! smart
       char[] ch = s.toCharArray();
       int start = 0;
       int end = ch.length - 1;
       while (start < end) {
           ch[start] = (char) (ch[start] ^ ch[end]);
           ch[end] = (char) (ch[start] ^ ch[end]);
           ch[start] = (char) (ch[start] ^ ch[end]);
           start++;
           end--;
       }
       return new String(ch);
   }

   public static String reverseString6(String s) { // Recursive
       int length = s.length();
       if (length <= 1) {
           return s;
       }
       String leftStr = s.substring(0, length / 2);
       String rightStr = s.substring(length / 2, length);
       return reverseString6(rightStr) + reverseString6(leftStr);
   }



   // 11. Container With Most Water
   public int maxArea(int[] height) { // O(n)
       if (height == null || height.length < 2) {
           return 0;
       }
       int left = 0;
       int right = height.length - 1;
       int result = 0;
       int temp = 0;

       while (left < right) {
           temp = (right - left) * Math.min(height[left], height[right]);
           result = Math.max(result, temp);
           if (height[left] < height[right]) {
               left++;
           } else {
               right--;
           }
       }

       return result;
   }

   // 345. Reverse Vowels of a String

   public static boolean checkVowel(char c) {
       if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
               || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
           return true;
       }
       return false;
   }


   public static String reverseVowels(String s) {
       char[] ch = s.toCharArray();
       int start = 0;
       int end = ch.length - 1;
       char temp;
       while (start < end) {
           if (checkVowel(ch[start]) && checkVowel(ch[end])) {
               temp = ch[end];
               ch[end] = ch[start];
               ch[start] = temp;
               start++;
               end--;
           } else {
               if (!checkVowel(ch[start])) {
                   start++;
               }
               if (!checkVowel(ch[end])) {
                   end--;
               }
           }
       }
       return new String(ch);
   }

   // 9.Palindrome Number
   public boolean isPalindrome(int x) {
       if(x < 0) return false;
       int y = x;
       int res = 0;
       while(y != 0) {
           res = res * 10 + y % 10;
           y /= 10;
       }
       return x == res;
   }


   // 288. Unique Word Abbreviation
//    private final String[] dict ;

//    public ValidWordAbbr(String[] dictionary) {
//        dict = dictionary;
//
//    }

   public boolean isUnique(String word, String[] dict) {
       int n = word.length();
       for (String s: dict) {
           if (word.equals(s)) {// for same word, take it as unique abbr, so just continue to ignore it
               continue;
           }
           int m = s.length();
           if (m == n && s.charAt(0) == word.charAt(0) && s.charAt(m - 1) == word.charAt(n - 1)) {
               return false;
           }
       }
       return true;
   }
//    public static void main(String[] argu) {
//        Editorial_Solution test = new Editorial_Solution();
//        String[] dic = {"deer", "door", "cake", "card" };
//        String word = "deer";
//        Boolean res = test.isUnique(word,dic);
//        System.out.println(res);
//
//    }

   // Pre-processing so that the repeat call of is Unique is O(1)
   public class ValidWordAbbr {
       private final Map<String, Boolean> abbrDict = new HashMap<>();
       private final Set<String> dict;

       public ValidWordAbbr(String[] dictionary) {
           dict = new HashSet<>(Arrays.asList(dictionary));
           for (String s : dict) {
               String abbr = toAbbr(s);
               abbrDict.put(abbr, !abbrDict.containsKey(abbr));
           }
       }

       public boolean isUnique(String word) {
           String abbr = toAbbr(word);
           Boolean hasAbbr = abbrDict.get(abbr);
           return hasAbbr == null || (hasAbbr && dict.contains(word));
       }

       private String toAbbr(String s) {
           int n = s.length();
           if (n <= 2) {
               return s;
           }
           return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
       }
   }

   // 28. strStr
   public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    // 243. Shortest Word Distance
   public int shortestDistanceI(String[] words, String word1, String word2) {
       int idx1 = -1, idx2 = -1;
       int minDistance = words.length;
       for (int i = 0; i < words.length; i++) {
           if (words[i].equals(word1)) {
               idx1 = i;
           } else if (words[i].equals(word2)) {
               idx2 = i;
           }
           if (idx1 != -1 && idx2 != -1) {
               minDistance = Math.min(minDistance,Math.abs(idx1 - idx2));
           }
       }
       return minDistance;
   }

   // 244. Shortest Word Distance II
   public class WordDistance {
       private HashMap<String, List<Integer>> map;
       public WordDistance(String[] words) {
           map = new HashMap<>();
           for (int i = 0; i < words.length; i++) {
               String w = words[i];
               if (map.containsKey(w)) {
                   map.get(w).add(i);
               } else {
                   List<Integer> list = new ArrayList<>();
                   list.add(i);
                   map.put(w,list);
               }
           }

       }

       public int shortest(String word1, String word2) {
           List<Integer> list1 = map.get(word1);
           List<Integer> list2 = map.get(word2);
           int result = Integer.MAX_VALUE;
           for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
               int idx1 = list1.get(i), idx2 = list2.get(j);
               if (idx1 < idx2) {
                   result = Math.min(result, idx2 - idx1);
                   i++;
               } else {
                   result = Math.min(result, idx1 - idx2);
                   j++;
               }
           }
           return result;

       }
   }
   // Your WordDistance object will be instantiated and called as such:
   // WordDistance wordDistance = new WordDistance(words);
   // wordDistance.shortest("word1", "word2");
   // wordDistance.shortest("anotherWord1", "anotherWord2");

   //  245. Shortest Word Distance III
   public int shortestWordDistanceIII(String[] words, String word1, String word2) {
       if(words == null || words.length < 2) return -1;
       int p1 = -1, p2 = -1, dist = Integer.MAX_VALUE;

       for(int i = 0; i < words.length; i ++) {
           if(words[i].equals(word1)) {
               if(!word1.equals(word2)) p1 = i;
           }
           if(words[i].equals(word2)) {
               if(word1.equals(word2)) p1 = p2;
               p2 = i;
           }

           if(p1 != -1 && p2 != -1) {
               dist = Math.min(dist, Math.abs(p2 - p1));
           }
       }
       return dist;
   }
   // 226. Invert Binary Tree
   public TreeNode invertTree_recursive(TreeNode root) {
       if (root == null) {
           return null;
       }
       TreeNode right = invertTree(root.right);
       TreeNode left = invertTree(root.left);
       root.left = right;
       root.right = left;
       return root;
   }

   public TreeNode invertTree(TreeNode root) {
       if (root == null) return null;
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       while (!queue.isEmpty()) {
           TreeNode current = queue.poll();
           TreeNode temp = current.left;
           current.left = current.right;
           current.right = temp;
           if (current.left != null) queue.add(current.left);
           if (current.right != null) queue.add(current.right);
       }
       return root;
   }


   // 283. Move Zeros
   public void moveZeroes(int[] nums) {
       int lastNonZeroFoundAt = 0;
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] != 0) {
               nums[lastNonZeroFoundAt++] = nums[i];
           }
       }
       for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
           nums[i] = 0;
       }
   }
   public void moveZeroesOpt(int[] nums) {
       int tmp;
       for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
           if (nums[cur] != 0) {
               tmp = nums[cur];
               nums[cur] = nums[lastNonZeroFoundAt];
               nums[lastNonZeroFoundAt] = tmp;
               lastNonZeroFoundAt++;
           }
       }
   }

   // 242. Valid Anagram
   public boolean isAnagram(String s, String t) { // Sorting O(nlogn)
       if (s.length() != t.length()) {
           return false;
       }
       char[] str1 = s.toCharArray();
       char[] str2 = t.toCharArray();
       Arrays.sort(str1);
       Arrays.sort(str2);
       return Arrays.equals(str1,str2);
   }
   public boolean isAnagram_hash(String s, String t) {
       if (s.length() != t.length()) {
           return false;
       }
       int[] table = new int[26];
       for (int i = 0; i < s.length(); i++) {
           table[s.charAt(i) - 'a']++;
       }
       for (int i = 0; i < t.length(); i++) {
           table[t.charAt(i) - 'a']--;
           if (table[t.charAt(i) - 'a'] < 0) {
               return false;
           }
       }
       return true;
   }
   // Follow up if contain unicode, use hash table

   // 27. Remove Element
   public int removeElement(int[] nums, int val) { // two pointers
       int i = 0;
       for (int j = 0; j < nums.length; j++) {
           if (nums[j] != val) {
               nums[i] = nums[j];
               i++;
           }
       }
       return i;
   }

   public int removeElement_rareE(int[] nums, int val) {
       // For cases that element to be removed are rare
       // SMART!
       int i = 0;
       int n = nums.length;
       while (i < n) {
           if (nums[i] == val) {
               nums[i] = nums[n - 1];
               // reduce array size by one
               n--;
           } else {
               i++;
           }
       }
       return n;
   }
   // 26. Remove Duplicates from Sorted Array
   public int removeDuplicates(int[] nums) {
       if (nums.length == 0) return 0;
       int i = 0;
       for (int j = 1; j < nums.length; j++) {
           if (nums[j] != nums[i]) {
               i++;
               nums[i] = nums[j];
           }
       }
       return i + 1;

   }

   // 374. Guess Number Higher or Lower
  //The guess API is defined in the parent class GuessGame.
  //@param num, your guess
  //@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     //int guess(int num);

   public class Solution extends GuessGame {
       public int GuessNumberHigherorLower(int n) {
           int low = 1;
           int high = n;
           while (low <= high) {
               int mid = low + (high - low) / 2;
               int res = guess(mid);
               if (res == 0)
                   return mid;
               else if (res < 0)
                   high = mid - 1;
               else
                   low = mid + 1;
           }
           return -1;
       }
   }

   // 232. Implement Queue using Stacks
   class MyQueue {
       // Push element x to the back of queue.
       private Stack<Integer> s1 = new Stack<>();
       private Stack<Integer> s2 = new Stack<>();
       private int front;

       public void push(int x) { // O(n)
           if (s1.empty())
               front = x;
           while (!s1.isEmpty())
               s2.push(s1.pop());
           s2.push(x);
           while (!s2.isEmpty())
               s1.push(s2.pop());
       }

       // Removes the element from the front of queue.
       public void pop() {
           s1.pop();  // O(1)
           if (!s1.empty())
               front = s1.peek();
       }

       // Get the front element.
       public int peek() { // O(1)
           return front;
       }

       // Return whether the queue is empty.
       public boolean empty() {
           return s1.isEmpty();// O(1)
       }
   }

   class MyQueue_2 {
       // Push element x to the back of queue.
       private Stack<Integer> s1 = new Stack<>();
       private Stack<Integer> s2 = new Stack<>();
       private int front;

       public void push(int x) { // O(1)
           if (s1.empty())
               front = x;
           s1.push(x);
       }

       // Removes the element from the front of queue.
       public void pop() { // O(1), worse O(n)
           if (s2.isEmpty()) {
               while (!s1.isEmpty()) {
                   s2.push(s1.pop());
               }
           }
           s2.pop();
       }

       // Get the front element.
       public int peek() { // O(1)
           if (!s2.isEmpty()) {
               return s2.peek();
           }
           return front;
       }

       // Return whether the queue is empty.
       public boolean empty() {
           return s1.isEmpty() && s2.isEmpty();// O(1)
       }
   }


   // 225. Implement Stack using Queues
   class MyStack {
       private Queue<Integer> q1 = new LinkedList<>();
       private Queue<Integer> q2 = new LinkedList<>();
       private int top;

       // Push element x onto stack.
       public void push(int x) {
           q1.add(x); // O(1)
           top = x;
       }

       // Removes the element on top of the stack.
       public void pop() {  // O(n)
           while (q1.size() > 1) {
               top = q1.remove();
               q2.add(top);
           }
           q1.remove();
           Queue<Integer> temp = q1;
           q1 = q2;
           q2 = temp;
       }

       // Get the top element.
       public int top() { // (1)
           return top;

       }

       // Return whether the stack is empty.
       public boolean empty() { // O(1)
           return q1.isEmpty();
       }
   }

   // Using one queue
   class MyStack_2 {
       private LinkedList<Integer> q1 = new LinkedList<>();

       // Push element x onto stack.
       public void push(int x) {
           q1.add(x);
           int sz = q1.size();
           while (sz > 1) {
               q1.add(q1.remove());
               sz--;
           }
       }

       public void pop() {
           q1.remove();
       }

       public int top() {
           return q1.peek();
       }

       public boolean empty() { // O(1)
           return q1.isEmpty();
       }
   }

   // 31. Next Permutation
   public void nextPermutation(int[] nums) {
           int i = nums.length - 2;
           while (i >= 0 && nums[i + 1] <= nums[i]) {
               i--;
           }
           if (i >=0) {
               int j = nums.length - 1;
               while (j >=0 && nums[j] <= nums[i]){
                   j--;
               }
               swap(nums,i,j);
           }
           reverse(nums, i+1);
       }
   private void reverse(int[] nums, int start) {
           int i = start, j = nums.length - 1;
           while (i < j) {
               swap(nums,i,j);
               i++;
               j--;
           }
       }
   private void swap(int[] nums, int i, int j) {
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
       }

   // 237. Delete Node in a Linked List
   public void deleteNode(ListNode node) {
           node.val = node.next.val;
           node.next = node.next.next;
       }

   // 83. Remove Duplicates from Sorted List
   public ListNode deleteDuplicates(ListNode head) {
           ListNode current = head;
           while (current != null && current.next != null) {
               if (current.next.val == current.val) {
                   current.next = current.next.next;
               } else {
                   current = current.next;
               }
           }
           return head;
       }

   // 206. Reverse Linked List
   public ListNode reverseList(ListNode head) { // iteratively
       ListNode prev = null;
       ListNode curr = head;
       while (curr != null) {
           ListNode nextTemp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextTemp;
       }
       return prev;
   }
   public ListNode reverseList_recursive(ListNode head) { // recursive
       if (head == null || head.next == null) return head;
       ListNode p = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return p;
   }
   public ListNode removeNthFromEnd(ListNode head, int n) { // two pass
           ListNode dummy = new ListNode(0);
           dummy.next = head;
           int length  = 0;
           ListNode first = head;
           while (first != null) {
               length++;
               first = first.next;
           }
           length -= n;
           first = dummy;
           while (length > 0) {
               length--;
               first = first.next;
           }
           first.next = first.next.next;
           return dummy.next;

       }
   public ListNode removeNthFromEnd_onepass(ListNode head, int n) { // one pass
           ListNode dummy = new ListNode(0);
           dummy.next = head;
           ListNode first = dummy;
           ListNode second = dummy;
           // Advances first pointer so that the gap between first and second is n nodes apart
           for (int i = 1; i <= n + 1; i++) {
               first = first.next;
           }
           // Move first to the end, maintaining the gap
           while (first != null) {
               first = first.next;
               second = second.next;
           }
           second.next = second.next.next;
           return dummy.next;
       }

   // 141. Linked List Cycle
   public boolean hasCycle_hash(ListNode head){ // hashtable
       Set<ListNode> nodeSeen = new HashSet<>();
       while (head != null) {
           if (nodeSeen.contains(head)) {
               return true;
           } else {
               nodeSeen.add(head);
           }
           head = head.next;
       }
       return false;
   }

   public boolean hasCycle(ListNode head) {
       if (head == null || head.next == null) {
           return false;
       }

       ListNode slow = head;
       ListNode fast = head.next;
       while (slow != fast) {
           if (fast == null || fast.next == null) {
               return false;
           }
           slow = slow.next;
           fast = fast.next.next;
       }
       return true;
   }

   // 142. Linked List Cycle II

   public ListNode detectCycleII(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;

       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;

           if (fast == slow) {
               ListNode newNode = head;
               while (newNode != slow) {
                   newNode = newNode.next;
                   slow = slow.next;
               }
               return slow;
           }
       }
       return null;
   }


   // 160. Intersection of Two Linked Lists
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode dummyA = headA;
       ListNode dummyB = headB;
       while (dummyA != dummyB) {
           dummyA = dummyA == null? headB : dummyA.next;
           dummyB = dummyB == null? headA : dummyB.next;
       }
       return dummyA;
   }

   // 2. Add Two Numbers
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummyHead = new ListNode(0);
       ListNode p = l1, q = l2, curr = dummyHead;
       int carry = 0;
       while (p != null || q != null) {
           int x = (p != null) ? p.val : 0;
           int y = (q != null) ? q.val : 0;
           int sum = carry + x + y;
           carry = sum / 10;
           curr.next = new ListNode(sum % 10);
           curr = curr.next;
           if (p != null) p = p.next;
           if (q != null) q = q.next;
       }
       if (carry > 0 ) {
           curr.next = new ListNode(carry);
       }
       return dummyHead.next;
   }


   // 303. Range Sum Query - Immutable
   public class NumArray_1 { // PreCache
       private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
       public NumArray_1(int[] nums) {
           for (int i = 0; i < nums.length; i++) {
               int sum = 0;
               for (int j = i; j < nums.length; j++) {
                   sum += nums[j];
                   map.put(Pair.create(i,j),sum);
               }
           }

       }

       public int sumRange(int i, int j) {
           return map.get(Pair.create(i,j));
       }
   }

   public class NumArray_dp {
       private int[] sum;
       public NumArray_dp(int[] nums) {
           sum = new int[nums.length + 1];
           for (int i = 0; i < nums.length; i++) {
               sum[i + 1] = sum[i] + nums[i];
           }
       }

       public int sumRange(int i, int j) {
           return sum[j + 1] - sum[i];
       }
   }

   // Your NumArray object will be instantiated and called as such:
   // NumArray numArray = new NumArray(nums);
   // numArray.sumRange(0, 1);
   // numArray.sumRange(1, 2);

   // 304. Range Sum Query 2D - Immutable
   public class NumMatrix {

       private int[][] dp;

       public NumMatrix(int[][] matrix) {
           if (matrix.length == 0 || matrix[0].length == 0) return;
           dp = new int[matrix.length + 1][matrix[0].length + 1];
           for (int r = 0; r < matrix.length; r++) {
               for (int c = 0; c < matrix[0].length; c++) {
                   dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
               }
           }
       }

       public int sumRegion(int row1, int col1, int row2, int col2) {
           return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
       }
   }


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

   // 198. House Robber
   //f(k) = Largest amount that you can rob from the first k houses.
   // Ai = Amount of money at the ith house.
   // f(k) = max(f(k – 2) + Ak, f(k – 1))
   public int rob(int[] nums) {
       int prevMax = 0;
       int currMax = 0;
       for (int x : nums) {
           int temp = currMax;
           currMax = Math.max(prevMax + x, currMax);
           prevMax = temp;
       }
       return currMax;
   }

   // 121. Best Time to Buy and Sell Stock
   public int maxProfit(int prices[]) {
       int minprice = Integer.MAX_VALUE;
       int maxprofit = 0;
       for (int i = 0; i < prices.length; i ++) {
           if (prices[i] < minprice) {
               minprice = prices[i];
           } else if (prices[i] - minprice > maxprofit) {
               maxprofit = prices[i] - minprice;
           }
       }
       return maxprofit;
   }

   // 122. Best Time to Buy and Sell Stock II
   public int maxProfitII(int[] prices) { // DP two pass
       int i = 0;
       int valley;
       int peak;
       int maxprofit = 0;
       while (i < prices.length - 1) {
           while (i < prices.length - 1 && prices[i] >= prices[i + 1])
               i++;
           valley = prices[i];
           while (i < prices.length - 1 && prices[i] <= prices[i + 1])
               i++;
           peak = prices[i];
           maxprofit += peak - valley;
       }
       return maxprofit;
   }
   public int maxProfitII_1pass(int[] prices) { // DP One pass
       int maxprofit = 0;
       for (int i = 1; i < prices.length; i++) {
           if (prices[i] > prices[i - 1]) {
               maxprofit += prices[i] - prices[i - 1];
           }
       }
       return maxprofit;
   }


   // 252. Meeting Rooms
   public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0;}
       Interval(int s, int e) { start = s; end = e;}
   }
   public boolean canAttendMeetings (Interval[] intervals) {
       Arrays.sort(intervals, new Comparator<Interval> () {
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           }
       });
       for (int i = 0; i < intervals.length - 1; i++) {
           if (intervals[i].end > intervals[i + 1].start) return false;
       }
       return true;
   }

   // 326. Power of Three
   public boolean isPowerOfThree(int n) { // loop O(log3n)
       if (n < 1) {
           return false;
       }
       while (n % 3 == 0) {
           n /= 3;
       }
       return n == 1;
   }
   public boolean isPowerOfThree_log(int n) { //n is a power of three if and only if i is an integer.
       // In Java, we check if a number is an integer by taking the decimal part (using % 1) and checking if it is 0.
       return (Math.log10(n) / Math.log10(3)) % 1 == 0;
   }
   public boolean isPowerOfThree_19(int n) {
       return n > 0 && 1162261467 % n == 0;
   }
   public boolean isPowerOfThree_base(int n) {//  checking if the string starts with 1 ^1,
       // is followed by zero or more 0s 0* and contains nothing else $.
       return Integer.toString(n, 3).matches("^10*$");
   }

   // 191. Number of 1 Bits
   public int hammingWeight(int n) {
       int bits = 0;
       int mask = 1;
       for (int i = 0; i < 32; i++) {
           if ((n & mask) != 0) {
               bits++;
           }
           mask <<= 1;
       }
       return bits;
   }

   public int hammingWeight_better(int n) { //O(1)
       int sum = 0;
       while (n != 0) {
           sum++;
           n &= (n - 1);
       }
       return sum;
   }

   // 101. Symmetric Tree
   public boolean isSymmetric_recursive(TreeNode root) {
       return isMirror(root,root);
   }
   public boolean isMirror(TreeNode t1, TreeNode t2) {
       if (t1 == null && t2 == null) return true;
       if (t1 == null || t2 == null) return false;
       return (t1.val == t2.val) && isMirror(t1.right, t2.left) &&isMirror(t1.left, t2.right);
   }
   public boolean isSymmetric_iter(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       q.add(root);
       while (!q.isEmpty()) {
           TreeNode t1 = q.poll();
           TreeNode t2 = q.poll();
           if (t1 == null && t2 == null) continue;
           if (t1 == null || t2 == null) return false;
           if (t1.val != t2.val) return false;
           q.add(t1.left);
           q.add(t2.right);
           q.add(t1.right);
           q.add(t2.left);
       }
       return true;
   }

   // 14. Longest Common Prefix
   // Approach #1 (Horizontal scanning)
   public String longestCommonPrefix_horizon(String[] strs) {
       if (strs.length == 0) return "";
       String prefix = strs[0];
       for (int i = 1; i < strs.length; i++) {
           while (strs[i].indexOf(prefix) != 0) {
               prefix = prefix.substring(0, prefix.length() - 1);
               if (prefix.isEmpty()) return "";
           }
       }
       return prefix;
   }
   //Approach #2 (Vertical scanning)
   public String longestCommonPrefix_vertical(String[] strs) {
       if (strs == null || strs.length == 0) return  "";
       for (int i = 0; i < strs[0].length(); i++) {
           char c = strs[0].charAt(i);
           for (int j = 1; j < strs.length; j++) {
               if (i == strs[j].length() || strs[j].charAt(i) != c) {
                   return strs[0].substring(0,i);
               }
           }
       }
       return strs[0];
   }
   // Approach #3 (Divide and conquer)
   // Approach #4 (Binary search)
   // Follow up! MARK



   // 280. Wiggle Sort
   public void wiggleSort(int[] nums) { // O(nlogn)
       Arrays.sort(nums);
       for (int i = 1; i < nums.length - 1; i += 2) {
           swap(nums, i, i + 1);
       }
   }
   public void wiggleSort_1pass(int[] nums) { // one pass O(n)
       for (int i = 0; i < nums.length - 1; i++) {
           if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
               swap(nums, i, i + 1);
           }
       }
   }


   // 328. Odd Even Linked List
   public ListNode oddEvenList(ListNode head) {
       if (head == null) return null;
       ListNode odd = head, even = head.next, evenHead = even;
       while (even != null && even.next != null) {
           odd.next = even.next;
           odd = odd.next;
           even.next = odd.next;
           even = even.next;
       }
       odd.next = evenHead;
       return head;
   }

   // 259. 3Sum Smaller
   public int threeSumSmaller(int[] nums, int target) {
       Arrays.sort(nums);
       int sum = 0;
       for (int i = 0; i < nums.length - 2; i++) {
           sum += twoSumSmaller(nums, i + 1, target - nums[i]);
       }
       return sum;
   }

   private int twoSumSmaller(int[] nums, int startIndex, int target) {
       int sum = 0;
       int left = startIndex;
       int right = nums.length - 1;
       while (left < right) {
           if (nums[left] + nums[right] < target) {
               sum += right - left;
               left++;
           } else {
               right--;
           }
       }
       return sum;
   }

   // 286. Walls and Gates
   private static final int EMPTY = Integer.MAX_VALUE;
   private static final int GATE = 0;
   private static final List<int[]> DIRECTIONS = Arrays.asList(
           new int[] { 1,  0}, // down
           new int[] {-1,  0}, // up
           new int[] { 0,  1}, // right
           new int[] { 0, -1}  // left
   );

   public void wallsAndGates(int[][] rooms) {
       int m = rooms.length;
       if (m == 0) return;
       int n = rooms[0].length;
       Queue<int[]> q = new LinkedList<>();
       for (int row = 0; row < m; row++) {
           for (int col = 0; col < n; col++) {
               if (rooms[row][col] == GATE) {
                   q.add(new int[] { row, col });
               }
           }
       }
       while (!q.isEmpty()) {
           int[] point = q.poll();
           int row = point[0];
           int col = point[1];
           for (int[] direction : DIRECTIONS) {
               int r = row + direction[0];
               int c = col + direction[1];
               if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                   continue;
               }
               rooms[r][c] = rooms[row][col] + 1;
               q.add(new int[] { r, c });
           }
       }
   }

   // 351. Android Unlock Patterns
   public class AndroidUnlockPatterns {

       private boolean used[] = new boolean[9];

       public int numberOfPatterns(int m, int n) {
           int res = 0;
           for (int len = m; len <= n; len++) {
               res += calcPatterns(-1, len);
               for (int i = 0; i < 9; i++) {
                   used[i] = false;
               }
           }
           return res;
       }

       private boolean isValid(int index, int last) {
           if (used[index])
               return false;
           // first digit of the pattern
           if (last == -1)
               return true;
           // knight moves or adjacent cells (in a row or in a column)
           if ((index + last) % 2 == 1)
               return true;
           // indexes are at both end of the diagonals for example 0,0, and 8,8
           int mid = (index + last)/2;
           if (mid == 4)
               return used[mid];
           // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
           if ((index%3 != last%3) && (index/3 != last/3)) {
               return true;
           }
           // all other cells which are not adjacent
           return used[mid];
       }

       private int calcPatterns(int last, int len) {
           if (len == 0)
               return 1;
           int sum = 0;
           for (int i = 0; i < 9; i++) {
               if (isValid(i, last)) {
                   used[i] = true;
                   sum += calcPatterns(i, len - 1);
                   used[i] = false;
               }
           }
           return sum;
       }
   }

   public class AndroidUnlockPatterns_dfs {
       // cur: the current position
       // remain: the steps remaining
       int DFS(boolean vis[], int[][] skip, int cur, int remain) {
           if(remain < 0) return 0;
           if(remain == 0) return 1;
           vis[cur] = true;
           int rst = 0;
           for(int i = 1; i <= 9; ++i) {
               // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
               if(!vis[i] && (skip[cur][i] == 0 || (vis[skip[cur][i]]))) {
                   rst += DFS(vis, skip, i, remain - 1);
               }
           }
           vis[cur] = false;
           return rst;
       }


       public int numberOfPatterns(int m, int n) {
           // Skip array represents number to skip between two pairs
           int skip[][] = new int[10][10];
           skip[1][3] = skip[3][1] = 2;
           skip[1][7] = skip[7][1] = 4;
           skip[3][9] = skip[9][3] = 6;
           skip[7][9] = skip[9][7] = 8;
           skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
           boolean vis[] = new boolean[10];
           int rst = 0;
           // DFS search each length from m to n
           for (int i = m; i <= n; ++i) {
               rst += DFS(vis, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
               rst += DFS(vis, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
               rst += DFS(vis, skip, 5, i - 1);        // 5
           }
           return rst;
       }

   }

   // 274. H-Index
   public int hIndex(int[] citations) { // O(nlogn)
       Arrays.sort(citations);
       int i = 0;
       while (i < citations.length && citations[citations.length - 1 - i] > i) {
           i++;
       }
       return i;
   }

   public int hIndex_counting_sort(int[] citations) { // MARK
       int n = citations.length;
       int[] papers = new int[n + 1];
       // counting papers for each citation number
       for (int c: citations)
           papers[Math.min(n, c)]++;
       // finding the h-index
       int k = n;
       for (int s = papers[n]; k > s; s += papers[k])
           k--;
       return k;
   }
   // 298. Binary Tree Longest Consecutive Sequence
   public int longestConsecutive(TreeNode root) {
       return dfs(root, null, 0);
   }

   private int dfs(TreeNode p, TreeNode parent, int length) {
       if (p == null) return length;
       length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
       return Math.max(length, Math.max(dfs(p.left, p, length),
               dfs(p.right, p, length)));
   }

   // 55. Jump Game
   public boolean canJump(int[] nums) { // Greedy
       int lastPos = nums.length - 1;
       for (int i = nums.length - 1; i >= 0; i--) {
           if (i + nums[i] >= lastPos) {
               lastPos = i;
           }
       }
       return lastPos == 0;
   }


   // 228. Summary Ranges
   public List<String> summaryRanges(int[] nums) {
       List<String> summary = new ArrayList<>();
       for (int i = 0, j = 0; j < nums.length; ++j) {
           // check if j + 1 extends the range [nums[i], nums[j]]
           if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
               continue;
           // put the range [nums[i], nums[j]] into the list
           if (i == j)
               summary.add(nums[i] + "");
           else
               summary.add(nums[i] + "->" + nums[j]);
           i = j + 1;
       }
       return summary;
   }

   // 376. Wiggle Subsequence
   public int wiggleMaxLength_greedy(int[] nums) { // Greedy
       if (nums.length < 2)
           return nums.length;
       int prevdiff = nums[1] - nums[0];
       int count = prevdiff != 0 ? 2 : 1;
       for (int i = 2; i < nums.length; i++) {
           int diff = nums[i] - nums[i - 1];
           if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
               count++;
               prevdiff = diff;
           }
       }
       return count;
   }

   public int wiggleMaxLength_dp(int[] nums) { //dp
       if (nums.length < 2)
           return nums.length;
       int down = 1, up = 1;
       for (int i = 1; i < nums.length; i++) {
           if (nums[i] > nums[i - 1])
               up = down + 1;
           else if (nums[i] < nums[i - 1])
               down = up + 1;
       }
       return Math.max(down, up);
   }

   // 5. Longest Palindromic Substring
   public String longestPalindrome(String s) {
       int start = 0, end = 0;
       for (int i = 0; i < s.length(); i++) {
           int len1 = expandAroundCenter(s, i, i);
           int len2 = expandAroundCenter(s, i, i + 1);
           int len = Math.max(len1, len2);
           if (len > end - start) {
               start = i - (len - 1) / 2;
               end = i + len / 2;
           }
       }
       return s.substring(start, end + 1);
   }

   private int expandAroundCenter(String s, int left, int right) {
       int L = left, R = right;
       while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
           L--;
           R++;
       }
       return R - L - 1;
   }
   // 3. Longest Substring Without Repeating Characters
   public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       Set<Character> set = new HashSet<>();
       int ans = 0, i = 0, j = 0;
       while (i < n && j < n) {
           // try to extend the range [i, j]
           if (!set.contains(s.charAt(j))){
               set.add(s.charAt(j++));
               ans = Math.max(ans, j - i);
           }
           else {
               set.remove(s.charAt(i++));
           }
       }
       return ans;
   }

   public int lengthOfLongestSubstring_optimal(String s) { // MARK
       int n = s.length(), ans = 0;
       Map<Character, Integer> map = new HashMap<>(); // current index of character
       // try to extend the range [i, j]
       for (int j = 0, i = 0; j < n; j++) {
           if (map.containsKey(s.charAt(j))) {
               i = Math.max(map.get(s.charAt(j)), i);
           }
           ans = Math.max(ans, j - i + 1);
           map.put(s.charAt(j), j + 1);
       }
       return ans;
   }

   // 221. Maximal Square
   public int maximalSquare(char[][] matrix) { // O(mn) O(mn)
       int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
       int[][] dp = new int[rows + 1][cols + 1];
       int maxsqlen = 0;
       for (int i = 1; i <= rows; i++) {
           for (int j = 1; j <= cols; j++) {
               if (matrix[i-1][j-1] == '1'){
                   dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                   maxsqlen = Math.max(maxsqlen, dp[i][j]);
               }
           }
       }
       return maxsqlen * maxsqlen;
   }

   public int maximalSquare_opt(char[][] matrix) { // O(mn) O(n)
       int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
       int[] dp = new int[cols + 1];
       int maxsqlen = 0, prev = 0;
       for (int i = 1; i <= rows; i++) {
           for (int j = 1; j <= cols; j++) {
               int temp = dp[j];
               if (matrix[i - 1][j - 1] == '1') {
                   dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                   maxsqlen = Math.max(maxsqlen, dp[j]);
               } else {
                   dp[j] = 0;
               }
               prev = temp;
           }
       }
       return maxsqlen * maxsqlen;

   }

   // 208. Implement Trie (Prefix Tree)
   class TrieNode {

       // R links to node children
       private TrieNode[] links;

       private final int R = 26;

       private boolean isEnd;

       public TrieNode() {
           links = new TrieNode[R];
       }

       public boolean containsKey(char ch) {
           return links[ch -'a'] != null;
       }
       public TrieNode get(char ch) {
           return links[ch -'a'];
       }
       public void put(char ch, TrieNode node) {
           links[ch -'a'] = node;
       }
       public void setEnd() {
           isEnd = true;
       }
       public boolean isEnd() {
           return isEnd;
       }
   }
   class Trie {
       private TrieNode root;
       public Trie() {
           root = new TriNode();
       }

       public void insert(String word) { // O(m) m = key length
           TrieNode node = root;
           for (int i = 0; i < word.length(); i++) {
               char currentChar = word.charAt(i);
               if (!node.containsKey(currentChar)) {
                   node.put(currentChar, new TrieNode());
               }
               node = node.get(currentChar);
           }
           node.setEnd();
       }

       private TrieNode serachPrefix (String word) {
           TrieNode node = root;
           for (int i = 0; i < word.length(); i++) {
               char curLetter = word.charAt(i);
               if (node.containsKey(curLetter)) {
                   node = node.get(curLetter);
               } else {
                   return null;
               }
           }
           return node;
       }

       public boolean search(String word) {
           TrieNode node = searchPrefix(word);
           return node != null && node.isEnd();
       }

       public boolean starsWith(String prefix) {
           TrieNode node = searchPrefix(prefix);
           return node != null;
       }
   }
   // 296. Best Meeting Point  MARK
   public int minTotalDistance(int[][] grid) {
       List<Integer> rows = collectRows(grid);
       List<Integer> cols = collectCols(grid);
       int row = rows.get(rows.size() / 2);
       int col = cols.get(cols.size() / 2);
       return minDistance1D(rows, row) + minDistance1D(cols, col);
   }

   private int minDistance1D(List<Integer> points, int origin) {
       int distance = 0;
       for (int point : points) {
           distance += Math.abs(point - origin);
       }
       return distance;
   }

   private List<Integer> collectRows(int[][] grid) {
       List<Integer> rows = new ArrayList<>();
       for (int row = 0; row < grid.length; row++) {
           for (int col = 0; col < grid[0].length; col++) {
               if (grid[row][col] == 1) {
                   rows.add(row);
               }
           }
       }
       return rows;
   }

   private List<Integer> collectCols(int[][] grid) {
       List<Integer> cols = new ArrayList<>();
       for (int col = 0; col < grid[0].length; col++) {
           for (int row = 0; row < grid.length; row++) {
               if (grid[row][col] == 1) {
                   cols.add(col);
               }
           }
       }
       return cols;
   }
*/
    //  166. Fraction to Recurring Decimal
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

//    public static void main (String[] argrs) {
//        int numerator = 1;
//        int denominator = 6;
//        Editorial_Solution test = new Editorial_Solution();
//        String ret = test.fractionToDecimal(numerator,denominator);
//        System.out.println(ret);
//
//    }
}
