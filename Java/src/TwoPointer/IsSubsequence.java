package TwoPointer;

/**
 * Created by JMYE on 9/7/16.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

}



/*

def isSubsequence(self, s, t):
    t = iter(t)
    return all(c in t for c in s)


def isSubsequence(self, s, t):
        start = 0
        for i in range(len(s)):
            start = t.find(s[i],start)
            if start==-1:
                return False
            start += 1
        return True



a = [1,2,3,4,5]
b = iter(a)
print 1 in b #True
print b.next() #2
print 1 in b #False
print b.next() #StopIteration
 */