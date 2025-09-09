class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        start=0
        end=len(arr)-1
        while(start<=end):
            mid=start+(end-start)//2
            missing=arr[mid]-(mid+1)
            if(missing>=k):
                end=mid-1
            else:
                start=mid+1
        return k+end+1
            
