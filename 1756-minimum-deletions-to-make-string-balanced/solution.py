class Solution:
    def minimumDeletions(self,s):
        ans=0
        count=0
        for i in s:
            if i=="b":
                count+=1
            elif count:
                ans+=1
                count-=1

        return ans
        
                

        
        
