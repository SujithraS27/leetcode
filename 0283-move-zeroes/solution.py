class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        k=0
        for i in range(len(nums)):
            if(nums[i]!=0):
                nums[k]=nums[i]
                k=k+1
        while(k<len(nums)):
            nums[k]=0
            k=k+1
        return nums
       
        
