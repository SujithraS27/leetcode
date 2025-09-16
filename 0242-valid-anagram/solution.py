class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s)!=len(t)):
            return False
        count=[0]*26
        for s1,s2 in zip(s,t):
            count[ord(s1)-ord('a')]+=1
            count[ord(s2)-ord('a')]-=1
        return all (x==0 for x in count)
        
