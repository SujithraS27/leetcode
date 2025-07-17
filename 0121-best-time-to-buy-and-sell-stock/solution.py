class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxprofit=0
        smallest=48305953058737
        for i in prices:
            if(i<smallest):
                smallest=i
            if(i-smallest)>maxprofit:
                maxprofit=i-smallest
        return maxprofit
            

