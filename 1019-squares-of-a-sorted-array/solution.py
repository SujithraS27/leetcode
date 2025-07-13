class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        start=0;
        end=len(nums)-1
        result=[]
        while start<=end:
            if abs(nums[start])<=abs(nums[end]):
                result.append(nums[end]**2)
                end=end-1
            if abs(nums[start])>abs(nums[end]):
                result.append(nums[start]**2)
                start=start+1
        result.reverse()
        return result
