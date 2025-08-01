class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cursum=0
        maxsum=nums[0]
        for num in nums:
            cursum=cursum+num
            if(cursum>maxsum):
                maxsum=cursum
            if(cursum<0):
                cursum=0
        return maxsum

