class Solution:
    def totalh(self,piles,k):
        total=0
        for i in range(len(piles)):
            total=total+math.ceil(piles[i]/k)
        return total
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        start=1
        end=max(piles)
        while(start<=end):
            mid=start+(end-start)//2
            if(self.totalh(piles,mid)<=h):
                end=mid-1
            else:
                start=mid+1
        return start

        
