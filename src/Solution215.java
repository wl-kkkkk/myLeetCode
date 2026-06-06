public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        buildMaxHeap(nums,len);
        for(int i=nums.length-1;i>=nums.length-k+1;--i){
            swap(nums,i,0);
            --len;
            maxHeapify(nums,len,0);
        }
        return nums[0];
    }

    /*
     * 造堆
     * @Param arr 待堆化的数组
     * @Param n   堆的大小，需要堆化的元素个数
     * */
    public void buildMaxHeap(int[] arr,int n){
        int i=n/2-1;
        for(;i>=0;i--){
            maxHeapify(arr,n,i);
        }
    }

    /*
    * 堆化方法
    * @Param arr 待堆化的数组
    * @Param n   堆的大小，需要堆化的元素个数
    * @Param i   当前需要堆化的父节点索引
    * */
    public void maxHeapify(int[] arr,int n,int i){

        int left=2*i+1;
        int right=2*i+2;
        int largest=i;

        if(left<n&&arr[left]>arr[largest]){
            largest=left;
        }
        if(right<n&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            maxHeapify(arr,n,largest);
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
