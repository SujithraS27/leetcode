class Solution {
    public int findNumbers(int[] nums) {
        int evenn=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            int num=nums[i];
            while(num>0){
                count=count+1;
                num=num/10;
            }
            if(count%2==0){
                evenn=evenn+1;
            }
        }
        return evenn;
    }
}
