class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        seen=set()
        k=0
        for i in range(len(nums)):
            if(nums[i] not in seen):
                nums[k]=nums[i]
                k=k+1
                seen.add(nums[i])
        return k
            

