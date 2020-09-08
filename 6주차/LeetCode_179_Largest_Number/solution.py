# Solution 참고함
# java compare 기능을 이런식으로 하는줄 몰랐다.

class LargerNumKey(str):
    def __lt__(x, y):
        return x+y > y+x
        
class Solution:
    def largestNumber(self, nums):
        largest_num = ''.join(sorted(map(str, nums), key=LargerNumKey))
        if largest_num[0] == '0':
            return '0' 
        else:
            return largest_num