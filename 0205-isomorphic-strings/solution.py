class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        a1=[0]*256
        a2=[0]*256
        for i in range(len(s)):
            if(a1[ord(s[i])]!=a2[ord(t[i])]):
                return False
            a1[ord(s[i])]=i+1
            a2[ord(t[i])]=i+1
        return True
            
