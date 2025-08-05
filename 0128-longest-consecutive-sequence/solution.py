class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numset=set(nums)
        longest=0
        for num in numset:
            if(num-1 not in numset):
                curnum=num
                length=1
                while curnum+1 in numset:
                    curnum=curnum+1
                    length=length+1
                longest=max(longest,length)
        return longest
