class Solution {
    public int[] findErrorNums(int[] nums) {
        cyclicsort(nums);
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i+1){
                continue;
            }
            else{
                ans[0]=nums[i];
                ans[1]=i+1;
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
