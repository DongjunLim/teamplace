# faster than 5.02%
# 그냥 와리가리 하면서 넣어줬다
# 너무 느리다
#  더 쉬운방법이 있을까?

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        N = len(s)
        answer = ''

        if numRows == 1:
            return s

        for j in range(numRows):
            row_num = 0
            for i in range(N):

                if row_num == j:
                    answer += s[i]
                # print(row_num)
                if row_num == 0:
                    row_change = 1
                elif row_num == numRows -1:
                    row_change = -1
                row_num += row_change
        
        return answer
    