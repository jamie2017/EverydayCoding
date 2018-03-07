package Greedy;

import java.util.Arrays;

/**
 * Created by JMYE on 5/10/17.
 * https://mp.weixin.qq.com/s?__biz=MzA5MzE4MjgyMw==&mid=2649457330&idx=1&sn=bbe85d08d4565c437e1e721b7a5a8372&chksm=887eecbabf0965acb1548d0e91db6643edcdcc56f032b864b4e932a1476bd058737a3fb8a3be&scene=0&key=f1597b91a8e8436ba7e34b738d164484841be7e6ac2b751a73baa43c0a9e68f6ca29339ebf43152add3d1bf4b20a2aa1b5ff22eefdafe312ddf29a217c3ddea4803297099b955f9157d872c22f6e5abd&ascene=0&uin=Mzg3NTAyNzc1&devicetype=iMac+MacBookPro12%2C1+OSX+OSX+10.12.4+build(16E195)&version=12020610&nettype=WIFI&fontScale=100&pass_ticket=W1dmlx0NgUOHlrUCwUAF3ehK0Px7CmgqYY8gLmTm6Vd5PTBta%2FTrOU53zNZSHJb2
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i,j;
        for (i = j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}
