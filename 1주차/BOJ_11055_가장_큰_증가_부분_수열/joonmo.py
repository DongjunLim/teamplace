import os
import sys

# dp를 사용했습니다.

curr_dr = os.path.dirname(__file__)
sys.stdin = open(curr_dr + '\input.txt' , 'r')

T = int(input())
A = list(map(int, input().split()))
dp = [x for x in A]

# print(dp)

# 기준 인덱스
for i in range(T):
    # 기준 인덱스 전 인덱스들을 앞에서 부터 확인
    for j in range(i):
        if A[i] > A[j]:
            # 맨 앞부터 전 인덱스와 현재 인덱스 값을 비교해서 더 큰값으로 점점 올라간다
            dp[i] = max(dp[i], dp[j] + A[i])
    # print(dp)

print(max(dp))

