class Solution:
    def countstudents(self,nums,pages):
        student=1
        nopages=0
        for i in range(len(nums)):
            if(nopages+nums[i]<=pages):
                nopages=nopages+nums[i]
            else:
                student=student+1
                nopages=nums[i]
        return student
    def splitArray(self, nums: List[int], m: int) -> int:
        start=max(nums)
        end=sum(nums)
        if(m>len(nums)):
            return -1
        ans=-1
        while(start<=end):
            mid=start+(end-start)//2
            if(self.countstudents(nums,mid)<=m):
                ans=mid
                end=mid-1
            else:
                start=mid+1
        return ans

        
