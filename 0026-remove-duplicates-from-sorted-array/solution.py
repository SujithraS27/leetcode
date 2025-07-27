class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        

        i = 0  # Points to last unique element
        for j in range(1, len(nums)):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]  # Move the new unique element next in line
        return i + 1
