class Solution {
    public int sum(int[] nums,int k){
        int s=0;
        for(int num:nums){
            s=s+(int)(Math.ceil((double)num/k));
        }
        return s;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int num:nums){
            high=Math.max(high,num);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int su=sum(nums,mid);
            if(su<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
