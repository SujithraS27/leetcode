class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        k=0
        j=1
        res = [0] * len(nums)
        for i in range(len(nums)):
            if(nums[i]>0):
                if(k<len(nums)-1):
                    res[k]=nums[i]
                    k=k+2
            else:
                if(j<=len(nums)-1):
                    res[j]=nums[i]
                    j=j+2
        return res
