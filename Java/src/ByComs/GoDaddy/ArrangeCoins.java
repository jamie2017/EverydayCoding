package ByComs.GoDaddy;

/**
 * Created by JMYE on 9/29/16.
 */

/*
Given number of coins in an array , we need to arrange it on each stairs according to number of stairs and return the final stair which contains equal number of coins as of number of stair
Example - No of Coins : 4
Stair 1 - 1
Stair 2 - 2
Stair 3 - 1

Returns = 2 , as stair 2 contain equal number of coins as of stair number.


Sample Input : { 2,5,8,3}
        Expected Output : 1 2 3 2

*/

public class ArrangeCoins {
    public static void main(String[] args) {
        long[] coins={ 2,5,8,3};
        arrangeCoinsPrinted(coins);
        arrangeCoins(coins);
    }
    static void arrangeCoinsPrinted(long[] n){
        for(int k=0;k<n.length;k++){
            int count=1;
            int sum =0;
            long temp=n[k];
            for(int i=1;i<=n[k];i++){
                int j;
                for(j=1;j<=i;j++){
                    if(temp>0){
                        System.out.print("*");
                        temp--;
                    }
                }
                System.out.println();
                sum=sum+i;
                if(sum<=n[k]){
                    count++;
                }
            }
            System.out.println("No of Stairs for :"+n[k]+" coins is "+(count-1));
        }
    }

    static void arrangeCoins(long[] n){

        for(int k=0;k<n.length;k++){
            int count=1;
            int sum =0;
            for(int i=1;i<=n[k];i++){
                sum=sum+i;
                if(sum<=n[k]){
                    count++;
                }
            }
            System.out.println("No of Stairs for :"+n[k]+" is "+(count-1));
        }

    }
}
