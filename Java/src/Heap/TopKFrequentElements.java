package Heap;

import java.util.*;

/**
 * Created by JMYE on 9/13/16.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length < k) {
            return rst;
        }
        HashMap<Integer,Integer> mapElement = new HashMap<>();
        for (int num: nums) {
            if (!mapElement.containsKey(num)) {
                mapElement.put(num,1);
            } else {
                mapElement.put(num,mapElement.get(num) +  1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());

        for(Map.Entry<Integer, Integer> entry : mapElement.entrySet()) {
            heap.offer(entry);
            if(heap.size() > k) heap.poll();
        }

        while(!heap.isEmpty()) {
            rst.add(0, heap.poll().getKey());
        }
        return rst;
    }

    /*

    def topKFrequent(self, nums, k):
        bucket = [[] for _ in nums]
        for num, freq in collections.Counter(nums).items():
            bucket[len(nums) - freq].append(num)
        return list(itertools.chain(*bucket))[:k]
     */

    public List<Integer> topKFrequent_BucketSort(int[] nums, int k) { // MARK!!

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    class Element {
        int  val;
        int freq;
        public Element(int v, int f) {
            val = v;
            freq = f;
        }
    }
    class ElementComparator implements Comparator<Element>{
        @Override
        public int compare(Element a, Element b) {
            return b.freq - a.freq;
        }
    }
    public List<Integer> topKFrequent_elemt(int[] nums, int k) {
        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num, map.get(num) + 1 );
            }
        }
        Queue<Element> heap = new PriorityQueue<>(map.size(), new ElementComparator());

        for (Integer key : map.keySet()) {
            heap.add(new Element(key, map.get(key)));
        }

        while (k > 0) {
            rst.add(heap.poll().val);
            k--;
        }
        return rst;
    }


    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(test.topKFrequent_elemt(nums,k));
    }
}
