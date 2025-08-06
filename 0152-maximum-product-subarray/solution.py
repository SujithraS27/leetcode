class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        curmin=nums[0]
        curmax=nums[0]
        maxprod=nums[0]
        for i in (nums[1:]):
            temp_max=max(i,i*curmax,i*curmin)
            curmin=min(i,i*curmax,i*curmin)
            curmax=temp_max
            maxprod=max(maxprod,curmax)
        return maxprod

