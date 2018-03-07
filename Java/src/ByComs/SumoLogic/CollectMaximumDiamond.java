package ByComs.SumoLogic;


/**
 * Created by JMYE on 7/4/17.
 *
 Given a matrix of n*n. Each cell contain 0, 1, -1.
 0 denotes there is no diamond but there is a path.
 1 denotes there is diamond at that location with a path
 -1 denotes that the path is blocked.
 Now you have start from 0,0 and reach to last cell & then return back to 0,0 collecting maximum no of diamonds.
 While going to last cell you can move only right and down.
 While returning back you can move only left and up.


 */
class Path {
    char dir;
    int cell;

    public Path(char dir, int cell) {
        this.dir = dir;
        this.cell = cell;
    }
}
public class CollectMaximumDiamond {

    public int maxDiamonMinePath(int[][] matrix) {
        int cnt1 = maxPath(matrix);
        int cnt2 = maxPath(matrix);
        int totalCnt = cnt1 + cnt2;
        return totalCnt;
    }
    public int maxPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0][0] == -1 || matrix[matrix.length - 1][matrix.length - 1] == -1) {
            return 0;
        }
        int n = matrix.length;
        Path[][] path = new Path[n][n];
        int i,j;
        for(i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                path[i][j] = new Path('#',matrix[i][j]);
            }
        }
        // Init first row
        for (j = 1; j < n; j++) {
            if (path[0][j].cell == -1) {
                continue;
            }
            if (path[0][j - 1].cell == -1) {
                path[0][j].cell = -1;
                continue;
            }
            path[0][j].dir = 'j';
            path[0][j].cell += path[0][j - 1].cell;
        }
        // Init first column
        for (i = 1; i < n; i++) {
            if (path[i][0].cell == -1){
                continue;
            }
            if (path[i - 1][0].cell == -1) {
                path[i][0].cell = -1;
                continue;
            }
            path[i][0].dir = 'i';
            path[i][0].cell += path[i - 1][0].cell;
        }
        for (i = 1; i < n; i++) {
            for (j = 1; j < n; j++) {
                // 8 combination conditions, skip when path[i][j].cell == -1
                if (path[i][j].cell != -1) {
                    if (path[i - 1][j].cell == -1 && path[i][j - 1].cell == -1) {
                        path[i][j].cell = -1;
                    } else if (path[i - 1][j].cell == -1) {
                        path[i][j].cell += path[i][j - 1].cell;
                        path[i][j].dir = 'j';
                    } else if (path[i][j - 1].cell == -1) {
                        path[i][j].cell += path[i - 1][j].cell;
                        path[i][j].dir = 'i';
                    } else {
                        if (path[i - 1][j].cell >= path[i][j - 1].cell) {
                            path[i][j].cell += path[i - 1][j].cell;
                            path[i][j].dir = 'i';
                        } else {
                            path[i][j].cell += path[i][j - 1].cell;
                            path[i][j].dir = 'j';
                        }
                    }
                }
            }
        }
        // Update matrix after collecting diamond
        i = n - 1;
        j = n - 1;
        while (i > 0 || j > 0) {
//            System.out.println("Path:(" + i +", " + j + '）');
            matrix[i][j] = 0;
            if (path[i][j].dir == 'i') i--;
            else if (path[i][j].dir == 'j') j--;
        }
//        System.out.println();
        matrix[0][0] = 0;
        return path[n - 1][n - 1].cell;
    }

    public static void main(String[] args) {
        CollectMaximumDiamond test = new CollectMaximumDiamond();
//        int[][] matrix = {{0 ,1 ,0 ,1 ,-1},
//                          {-1,0 ,1 ,0 ,-1},
//                          {1 ,1 ,1 ,0 , 1},
//                          {0 ,0 ,1 ,-1, 1},
//                          {1 ,0 ,1 ,0 , 1}};


//        int[][] matrix = {{0,1,-1},{1,0,-1}, {1,1,1}}; // 5
//        int[][] matrix = {{0,1,1},{1,0,1}, {1,1,1}}; // 7
        int[][] matrix = {{0,1,1},{1,0,-1}, {1,1,-1}}; // 0

//        int cnt1 = test.maxPath(matrix);
//        int cnt2 = test.maxPath(matrix);
//        int totalCnt = cnt1 + cnt2;
//        System.out.println(cnt1 +" "+ cnt2+" "+totalCnt);
        System.out.println(test.maxDiamonMinePath(matrix));

    }
}
