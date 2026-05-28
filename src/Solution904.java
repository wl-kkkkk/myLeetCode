public class Solution904 {
    public int totalFruit(int[] fruits) {
        int ans=0;
        //题目可以解读为，寻找连续最长子数组，里面只有两种元素
        //剪枝1：如果是连续一种，就可以跳过；
        //剪枝2：如果ans答案已经超过了剩下的种类，就可以break了
        for(int i=0;i<fruits.length;i++){
            if(ans>fruits.length-i) break;//剪枝2
            int res=1;
            int sort1=fruits[i],sort2=-1;
            for(int j=i+1;j<fruits.length;j++){
                if(fruits[j]!=sort1&&sort2==-1) sort2=fruits[j];
                else if(fruits[j]!=sort1&&sort2!=fruits[j]) break;
                res++;
            }
            ans=Math.max(ans,res);
            //在这里进行剪枝1谁都不影响
            while(i+1<fruits.length&&fruits[i+1]==fruits[i]){
                i=i+1;
            }
        }
        return ans;
    }
}
