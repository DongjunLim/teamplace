# Runtime: 672 ms,
# Memory Usage: 13.9 MB
# O(N^2)

class Solution:
    def countSubstrings(self, s: str) -> int:
        count = len(s)
        for start in range(len(s)):
            for cnt in range(start + 1, len(s)):
                if s[ start : floor((start+cnt)/2) + 1 ] == s[ cnt : ceil((start+cnt)/2) - 1 : -1 ]:
                    count += 1
        return count
                    
