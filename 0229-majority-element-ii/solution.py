class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        candidate1,candidate2=None,None
        count1,count2=0,0
        for candidate in nums:
            if(candidate==candidate1):
                count1=count1+1
            elif(candidate==candidate2):
                count2=count2+1
            elif(count1==0):
                candidate1,count1=candidate,1
            elif(count2==0):
                candidate2,count2=candidate,1
            else:
                count1=count1-1
                count2=count2-1
        result=[]
        for i in {candidate1,candidate2}:
            if i is not None and nums.count(i)>len(nums)//3:
                result.append(i)
        return sorted(result)
        
