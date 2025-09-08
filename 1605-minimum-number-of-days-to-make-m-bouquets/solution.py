class Solution:
    def nobouquet(self,bloomDay,day,m,k):
        count=0
        bouquet=0
        for i in range(len(bloomDay)):
            if(bloomDay[i]<=day):
                count=count+1
                if(count==k):
                    bouquet=bouquet+1
                    count=0
            else:
                count=0
        return bouquet

    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        start=min(bloomDay)
        end=max(bloomDay)
        if(len(bloomDay)<m*k):
                return -1
        while(start<=end):
            mid=start+(end-start)//2
            res=self.nobouquet(bloomDay,mid,m,k)
            ans=0
            if(res>=m):
                ans=mid
                end=mid-1
            else:
                start=mid+1
        return start
        
