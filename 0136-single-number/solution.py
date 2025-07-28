class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        nu=nums[0]
        for i in range(1,len(nums)):
            nu=nu^nums[i]
        return nu
