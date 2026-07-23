class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curmax=nums[0];
        int maxsum=nums[0];
        int curmin=nums[0];
        int minsum=nums[0];
        for(int i=1;i<nums.length;i++){
            curmax=Math.max(curmax+nums[i],nums[i]);
            maxsum=Math.max(maxsum,curmax);
            curmin=Math.min(curmin+nums[i],nums[i]);
            minsum=Math.min(minsum,curmin);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}