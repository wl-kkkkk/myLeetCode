//寻找两个正序数组的中位数
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        double res=0;
        int n1=nums1.length;
        int n2=nums2.length;
        int k=n1+n2;      
        //找到要找第几小的数字
        if((n1+n2)%2==0){
            int k1=(k/2);
            res+=findK(nums1,nums2,k1,n1,n2);
            int k2=(k/2+1);
            res+=findK(nums1,nums2,k2,n1,n2);
            res/=2;
        }else{
            int k3=k/2+1;
            res+=findK(nums1,nums2,k3,n1,n2);
        }
        return res;
    }
    public double findK(int[] nums1,int[] nums2,int k,int n1,int n2){
        //存储n1,n2的索引数以及没被遍历的数字数
        int i1=0,i2=0;
        //判断是否为空
        if(n1==0&&n2!=0){
            return (double)nums2[k-1];
        }
        if(n1==0&&n2==0){
            return (double)0;
        }
        //不为空的情况,很简单,只有边界问题判断
        while(true){
            //刚开始就空，以及遍历之后空
            if(i1==n1){
                return nums2[i2+k-1];
            }
            if(i2==n2){
                return nums1[i1+k-1];
            }
            if(k==1){
                return Math.min(nums1[i1],nums2[i2]);
            }
            //正常情况
            int half=k/2;
            int newIndex1=Math.min(i1+half,n1)-1;
            int newIndex2=Math.min(i2+half,n2)-1;
            if(nums1[newIndex1]<=nums2[newIndex2]){
                k-=(newIndex1-i1+1);
                i1=newIndex1+1;//到下一个未遍历的数
            }else{
                k-=(newIndex2-i2+1);
                i2=newIndex2+1;
            }

        }
    }
}
