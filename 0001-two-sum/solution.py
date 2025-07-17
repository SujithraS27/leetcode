class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for start in range(len(nums)):
            ele = target - nums[start]
            if ele in seen:
                return [seen[ele], start]
            seen[nums[start]] = start

