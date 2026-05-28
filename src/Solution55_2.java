public class Solution55_2 {
    public boolean canJump(int[] nums){
        int num=0;
        for(int i=0;i<nums.length&&num>=i;i++){
            System.out.println(num);
            num=Math.max(i+nums[i],num);
        }
        if(num>=nums.length-1) return true;
        else return false;
    }
}
