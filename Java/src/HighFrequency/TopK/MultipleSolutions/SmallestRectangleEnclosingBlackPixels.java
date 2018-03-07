package HighFrequency.TopK.MultipleSolutions;

/**
 * Created by JMYE on 11/21/16.
 */
public class SmallestRectangleEnclosingBlackPixels {
    /*
    [
     "0010",
     "0110",
     "0100"
    ]
     */

    //  scan it with largest range on each axis, it's even don't use x/y at al
    public int minAreaScan(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int m = image.length, n = image[0].length;
        int lenY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] != '0') {
                    lenY++;
                    break;
                }
            }
        }
        int lenX = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (image[j][i] != '0') {
                    lenX++;
                    break;
                }
            }
        }
        return lenX * lenY;
    }

    // if the image is not sparse, just few black pixel, dfs will be better
    private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    public int minArea_DFS(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        dfs(image, x, y);
        return(maxX - minX + 1) * (maxY - minY + 1);
    }
    private void dfs(char[][] image, int x, int y){
        int m = image.length, n = image[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0') return;
        image[x][y] = '0';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }

    // projection!!!
    // when project to 1D all the pixel will be connected
    // do vertical and horizen search
    // O(mlogn + nlogm)

    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int colMin = binarySearch(image, true, 0, y, 0, m, true);
        int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
        int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
        int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
        return (rowMax - rowMin) * (colMax - colMin);
    }

    public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while(lower < upper) {
            int mid = lower + (upper - lower) / 2;
            boolean inside = false;
            for(int i = min; i < max; i++) {
                if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    inside = true;
                    break;
                }
            }
            if(inside == goLower) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    public static void main(String[] args) {
        char[][] images = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        SmallestRectangleEnclosingBlackPixels test = new SmallestRectangleEnclosingBlackPixels();
        System.out.println(test.minArea_DFS(images, 0, 2));
    }
}
