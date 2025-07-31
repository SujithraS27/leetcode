class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen={}
        for i in range(len(nums)):
            ele=target-nums[i]
            if(ele in seen):
                return [i,seen[ele]]
            seen[nums[i]]=i
