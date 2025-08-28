class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def first(nums,target):
            start=0
            end=len(nums)-1
            first=-1
            while(start<=end):
                mid=start+(end-start)//2
                if(nums[mid]==target):
                    first=mid
                    end=mid-1
                elif(nums[mid]<target):
                    start=mid+1
                else:
                    end=mid-1
            return first
        def last(nums,target):
            start=0
            end=len(nums)-1
            last=-1
            while(start<=end):
                mid=start+(end-start)//2
                if(nums[mid]==target):
                    last=mid
                    start=mid+1
                elif(nums[mid]<target):
                    start=mid+1
                else:
                    end=mid-1
            return last
        return [first(nums,target),last(nums,target)]

