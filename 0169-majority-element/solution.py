class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        element=None
        count=0
        for num in nums:
            if count==0:
                element=num
            if num==element:
                count=count+1
            else:
                count=count-1
        if(nums.count(element)>len(nums)//2):
            return element
        
