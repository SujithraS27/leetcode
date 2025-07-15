class Solution:
    def maxArea(self, nums: List[int]) -> int:
        start=0
        end=len(nums)-1
        maxarea=0
        while(start<end):
            width=end-start
            height=min(nums[start],nums[end])
            area=height*width
            maxarea=max(maxarea,area)
            if nums[start] < nums[end]:
                start += 1
            else:
                end -= 1
        return maxarea


