class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        int diff=xor&(-xor);
        int x=0;
        int y=0;
        for(int i=0;i<nums.length;i++){
            if((diff&nums[i])==0){
                x=x^nums[i];
            }
            else{
                y=y^nums[i];
            }
        }
        return new int[]{x,y};
    }
}
