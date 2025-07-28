class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n=len(nums)
        sumnum=(n*(n+1))/2
        sum1=0
        for i in nums:
            sum1=sum1+i
        diff=sumnum-sum1
        return int(diff)
