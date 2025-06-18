class Solution {
    public int missingNumber(int[] nums) {
        int sum_N=(nums.length*(nums.length+1))/2;
        int sum_arr=0;
        for(int i=0;i<nums.length;i++){
            sum_arr=sum_arr+nums[i];
        }
        int diff=sum_N-sum_arr;
        return diff;
    }
}
