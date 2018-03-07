package Heap;

import java.util.List;

/**
 * Created by JMYE on 6/29/17.
 */

/*
You have k lists of sorted integers.
Find the smallest range that includes at least one number from each of the k lists.
For example,
List 1: [4, 10, 15, 24,26]
List 2: [0, 9, 12, 20] num = 9 index[1] = 1
List 3: [5, 18, 22, 30]index[2] = 0 num = 5
output = [20,24]
 */
public class SmallestRangeOfOverlapLists {
//    public int[] getSmallestRangeOverlap(List<List<Integer>> kLists) {

//    }
}


/*


'''
You have k lists of sorted integers.
Find the smallest range that includes at least one number from each of the k lists.
For example,
List 1: [4, 10, 15, 24,26]
List 2: [0, 9, 12, 20] num = 9 index[1] = 1
List 3: [5, 18, 22, 30]index[2] = 0 num = 5
output = [20,24]
'''
class SmallestRangeOfOverlapLists(object):
    def getSmallestRangeOverlap(self, kLists):
        minHeap = []
        for i in range(len(kLists)):
            heapq.heappush(minHeap,(kLists[i][0],i,0))
        smallestRange = [float('-inf'),float('inf')]
        while True:
            r_start, i,j = heapq.heappop(minHeap)
            r_end = max(minHeap)[0]
            smallestRange = min(smallestRange,[r_start,r_end],key = lambda a:abs(a[1] - a[0]))
            if j + 1 >= len(kLists[i]):
                break
            j += 1
            heapq.heappush(minHeap,(kLists[i][j],i,j))
        return smallestRange

 */