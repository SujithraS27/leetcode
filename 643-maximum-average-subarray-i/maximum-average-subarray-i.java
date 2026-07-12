class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        double sum=0;
        double maxlen=Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            sum=sum+nums[right];
            if(right-left+1>k){
                sum=sum-nums[left];
                left++;
            }
            if(right-left+1==k){
                maxlen=Math.max(sum,maxlen);
            }
        }
        return maxlen/k;
    }
}