#  dfs를 사용해서 완전 탐색

from collections import deque  

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        answer = []

        def dfs(n):
            start = '('
            q = deque()
            q.append(start)

            while q:
                tmp = q.popleft()
                # 왼쪽 괄호 오른쪽 괄호 개수 확인
                left = tmp.count('(')
                right = tmp.count(')')

                # 왼쪽 오른쪽 괄호가 n개면 answer로 넣어준다
                if left == right == n:
                    answer.append(tmp)
                # 괄호 개수가 같으면 왼쪽 괄호 추가
                elif left == right:
                    q.append(tmp + '(' )
                
                # 그 외에는 왼쪽 괄호 오른쪽 괄호 추가한 경우 모두 큐에 넣어준다
                elif n >= left > right :
                    q.append(tmp + '(')
                    q.append(tmp + ')')
                # print(q)
            return answer

        return dfs(n)
        