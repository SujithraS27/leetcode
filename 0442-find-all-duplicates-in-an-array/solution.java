class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        cyclicsort(nums);
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i+1){
                continue;
            }
            else{
                li.add(nums[i]);
            }
        }
        return li;
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
