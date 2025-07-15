class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
       start=0
       for current in range(len(nums)):
        if nums[current] != 0:
            nums[start], nums[current] = nums[current], nums[start]
            start += 1
        
