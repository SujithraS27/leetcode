class Solution {
    public int findDuplicate(int[] nums) {
        cyclicsort(nums);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i+1){
                continue;
            }
            else{
                ans=nums[i];
            }
        }
        return ans;
    }
    void cyclicsort(int[] nums){
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[correct];
                nums[correct]=nums[i];
                nums[i]=temp;
            }
            else{
                i++;
            }
        }
    }
}
