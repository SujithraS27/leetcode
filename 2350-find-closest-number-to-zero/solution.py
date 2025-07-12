class Solution(object):
    def findClosestNumber(self, nums):
        close_num=nums[0]
        close_dist=abs(nums[0])
        for i in nums:
            dist=abs(i-0)
            if(dist<close_dist):
                close_dist=dist
                close_num=i
            elif dist==close_dist and i>close_num:
                close_num=i
        return close_num

