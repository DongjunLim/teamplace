# Runtime: 20 ms
# Memory Usage: 12.7 MB

# stack을 사용했습니다.

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """

        start = ['(', '{', '[']
        end = [')', '}', ']']
        stack = []

        # 각 괄호에 맞는짝인지 확인
        for i in s:
            if i in start:
                stack.append(i)
            if i in end:
                try:
                    tmp = stack.pop()
                except IndexError:
                    return False
                if i == ')':
                    if tmp == '(':
                        continue
                    else:
                        return False
                elif i == '}':
                    if tmp == '{':
                        continue
                    else:
                        return False
                elif i == ']':
                    if tmp == '[':
                        continue
                    else:
                        return False
        
        # stack에 뭔가 남아있으면 False
        if stack:
            return False
        else:
            return True