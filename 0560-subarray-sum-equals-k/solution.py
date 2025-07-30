class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        seen = {}
        prefix_sum = 0
        count = 0
        seen[0] = 1  # base case: sum 0 has occurred once

        for i in range(len(nums)):
            prefix_sum += nums[i]

            if (prefix_sum - k) in seen:
                count += seen[prefix_sum - k]

            if prefix_sum in seen:
                seen[prefix_sum] += 1
            else:
                seen[prefix_sum] = 1

        return count

