public class Solution238 {
    public int[] productExceptSelf(int[] nums) {

        int nlen=nums.length;
        int[] tempnums1=new int[nlen],tempnums2=new int[nlen];
        int index1=0,index2=nlen-1;
        tempnums1[index1]=1;
        tempnums2[index2]=1;

        int cut=0;
        while(cut<nlen-1){
            tempnums1[++index1]=nums[index1-1]*tempnums1[index1-1];
            tempnums2[--index2]=nums[index2+1]*tempnums2[index2+1];
            cut++;
        }

        for(int j=0;j<nlen;j++){
            nums[j]=tempnums1[j]*tempnums2[j];
        }

        return nums;
    }
}
