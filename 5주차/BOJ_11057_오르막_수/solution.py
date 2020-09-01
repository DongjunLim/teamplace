# dp 사용해서 풀이
# https://suri78.tistory.com/92 참고

from collections import deque

N = int(input())

num = [1]*10
def dp(N):
    for i in range(N-1):
        for j in range(1, 10):
            num[j] = num [j] + num[j-1]
    # print(num)
    return sum(num)


print(dp(N)%10007)

# dfs 로 풀었다가 시간초과

# def dfs():
#     answer = 0
#     stack = deque()
#     for i in range(10):
#         stack.append(str(i))
#     while stack:
#         tmp_num_str = stack.pop()
#         # 숫자 미완성
#         if len(tmp_num_str) < N:
#             for digit in range(10):
#                 if int(tmp_num_str[-1]) <= digit:
#                     stack.append(tmp_num_str + str(digit))
#         # 숫자 완성
#         else:
#             answer += 1
#         # print(stack)
#     return answer
