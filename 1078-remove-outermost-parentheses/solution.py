class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        result=""
        depth=0
        for ch in s:
            if ch=='(':
                if(depth>0):
                    result=result+ch
                depth=depth+1
            else:
                depth=depth-1
                if(depth>0):
                    result=result+ch
        return result
