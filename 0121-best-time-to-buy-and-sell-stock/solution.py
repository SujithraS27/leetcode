class Solution:
    def maxProfit(self, nums: List[int]) -> int:
        maxprofit=0
        smallest=496593672788935587
        for i in nums:
            if(i<smallest):
                smallest=i
            if((i-smallest)>maxprofit):
                maxprofit=i-smallest
        return maxprofit
        
