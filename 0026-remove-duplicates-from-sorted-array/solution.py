class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            while(i<len(nums)-1 and nums[i]==nums[i+1]):
                del nums[i]
                continue
        return len(nums)
            

