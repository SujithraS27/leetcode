class Solution:
    def firstMissingPositive(self, arr):
        n=len(arr)
        for i in range(n):
            if(arr[i]<=0 or arr[i]>n):
                arr[i]=n+1
        for i in range(n):
            val=abs(arr[i])
            if(val>=1 and val<=n):
                if(arr[val-1]>0):
                    arr[val-1]=-arr[val-1]
        for i in range(n):
            if(arr[i]>0):
                return i+1
        return n+1
        
