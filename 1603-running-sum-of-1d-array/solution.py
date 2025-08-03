class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        cur_sum=0
        for i in range(len(nums)):
            cur_sum=cur_sum+nums[i]
            nums[i]=cur_sum
        return nums

