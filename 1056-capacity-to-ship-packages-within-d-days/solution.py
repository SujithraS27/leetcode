class Solution:
    def func(self,weights,cap):
        load=0
        day=1
        for i in range(len(weights)):
            if(load+weights[i]>cap):
                day=day+1
                load=weights[i]
            else:
                load=load+weights[i]
        return day
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        start=max(weights)
        end=sum(weights)
        while(start<=end):
            mid=start+(end-start)//2
            if(self.func(weights,mid)<=days):
                end=mid-1
            else:
                start=mid+1
        return start
        
