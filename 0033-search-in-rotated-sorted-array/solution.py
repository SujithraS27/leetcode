class Solution:
    def search(self, nums: List[int], target: int) -> int:
        pivot=self.findpivot(nums)
        if(pivot==-1):
            return self.binsearch(nums,target,0,len(nums)-1)
        if(nums[pivot]==target):
            return pivot
        if(target<nums[0]):
            return self.binsearch(nums,target,pivot+1,len(nums)-1)
        if(target>=nums[0]):
            return self.binsearch(nums,target,0,pivot-1)
        return -1


    def binsearch(self,nums,target,start,end):
        while(start<=end):
            mid=start+(end-start)//2
            if(nums[mid]==target):
                return mid
            if(nums[mid]>target):
                end=mid-1
            else:
                start=mid+1
        return -1

    def findpivot(self,nums):
        start=0
        end=len(nums)-1
        while(start<=end):
            mid=start+(end-start)//2
            if(mid<end and nums[mid]>nums[mid+1]):
                return mid
            if(mid>start and nums[mid]<nums[mid-1]):
                return mid-1
            if(nums[start]>=nums[mid]):
                end=mid-1
            if(nums[start]<nums[mid]):
                start=mid+1
        return -1

