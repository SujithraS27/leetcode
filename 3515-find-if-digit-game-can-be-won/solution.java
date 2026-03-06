class Solution {
    public boolean canAliceWin(int[] nums) {
        int digitcount;
        int singles=0;
        int doubles=0;
        for(int i=0;i<nums.length;i++){
            digitcount=0;
            int temp=nums[i];
            while(temp>0){
                int digit=nums[i]%10;
                temp=temp/10;
                digitcount=digitcount+1;
            }
            if(digitcount==1){
                singles=singles+nums[i];
            }
            else{
                doubles=doubles+nums[i];
            }
        }
        return (singles!=doubles);
    }
}
