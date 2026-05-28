public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(target<=matrix[i][matrix[i].length-1]){
                Boolean ans=find(matrix[i],target);
                return ans;
            }
        }
        return false;
    }
    public Boolean find(int[] nums,int target){
        int l=-1,r=nums.length;
        while(l+1!=r){
            int mid=(l+r)/2;
            if(nums[mid]<target) l=mid;
            else if(nums[mid]>target) r=mid;
            else return true;
        }
        return false;
    }
}
