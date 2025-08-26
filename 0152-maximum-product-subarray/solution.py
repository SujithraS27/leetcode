class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res=max(nums)
        curmax,curmin=1,1
        for i in nums:
            if(i==0):
                curmax,curmin=1,1
                continue
            temp=curmax*i
            curmax=max(temp,curmin*i,i)
            curmin=min(temp,curmin*i,i)
            res=max(res,curmax,curmin)
        return res
