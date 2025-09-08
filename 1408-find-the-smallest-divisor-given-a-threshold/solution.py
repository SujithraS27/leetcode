class Solution:
    def func(self,nums,d):
        summ=0
        for i in nums:
            summ=summ+math.ceil(i/d)
        return summ
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        start=1
        end=max(nums)
        while(start<=end):
            mid=start+(end-start)//2
            res=self.func(nums,mid)
            ans=0
            if(res<=threshold):
                ans=mid
                end=mid-1
            else:
                start=mid+1
        return start
