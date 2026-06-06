import java.util.Arrays;
import java.util.Comparator;

class SolutionQ2 {
    public int maximumSaleItems(int[][] items, int budget) {

        int res=0;
        int ilen=items.length;
        int[] give=new int[ilen];//存放买你送的个数
        Arrays.sort(items,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o2[0]-o1[0];
            }
        });
        for(int i=0;i<ilen;i++){
            for(int j=i+1;j<ilen;j++){
                if(items[i][0]%items[j][1]==0){
                    give[j]++;
                }
            }
        }

        int[] dp = new int[budget+1];
        for(int i=0;i<ilen;i++){
            int price=items[i][1];
            for(int j=price;j<=budget;j++){
                dp[j]=Math.max(dp[j],dp[j-price]+1+give[i]);
                res=Math.max(res,dp[j]);
            }
        }
        return res;
    }
}