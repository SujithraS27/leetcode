class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<Integer>();
        int result[]=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()&& dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                result[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
