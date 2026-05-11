class Solution {
    static void reverse(int[] nums,int k,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,k,0,n-1);
        reverse(nums,k,0,k-1);
        reverse(nums,k,k,n-1);
        
    }
}
