class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        curmax,curmin=0,0
        globalmax,globalmin=nums[0],nums[0]
        total=0
        
        for i in range(len(nums)):
            curmax=max(nums[i],curmax+nums[i])
            curmin=min(nums[i],curmin+nums[i])
            globalmax=max(globalmax,curmax)
            globalmin=min(globalmin,curmin)
            total=total+nums[i]
        if(globalmax<0):
            return max(nums)
        else:
            res=max(globalmax,total-globalmin)
            return res


        
