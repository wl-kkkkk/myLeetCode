public class Solution189 {
    public void rotate(int[] nums, int k) {
        int[] temp=nums.clone();

        int nlen=nums.length;
        for(int i=0;i<nlen;i++){
            nums[(i+k)%nlen]=temp[i];
        }
    }
}
