class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        num_s = [str(n) for n in nums]
        num_s.sort(key=lambda x: x*10, reverse=True)

        if num_s[0] == "0":
            return num_s[0]
        
        return "".join(num_s)
