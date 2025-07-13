class Solution:
    def isPalindrome(self, s: str) -> bool:
        start=0
        end=len(s)-1
        flag=0
        while(start<=end):
            if s[start].isalnum() and s[end].isalnum():
                if s[start].lower()==s[end].lower():
                    start=start+1
                    end=end-1
                else:
                    return False
            elif not s[start].isalnum():
                start=start+1
            elif not s[end].isalnum():
                end=end-1
        return True
        

