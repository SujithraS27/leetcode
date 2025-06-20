class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=binsearch(nums,target,true);
        ans[1]=binsearch(nums,target,false);
        return ans;
    }
    int binsearch(int [] nums,int target,boolean findsearchindex){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else{
                ans=mid;
                if(findsearchindex==true){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
