class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
        List<Integer> ans=new ArrayList<>();
        for(int in=0;in<nums.length;in++){
            if(nums[in]==in+1){
                continue;
            }
            else{
                ans.add(in+1);
            }
        }
       return ans; 
    }
}
