# dp로 풀이
# 몇번째 푸는데도 못풀겠다
# 난 빡대가리가 분명하다

import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

N = int(input())
T = []
P = []

# 모든 날짜 보상 0 으로 초기화
dp = [0]*(N+1)

for _ in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

for i in range( N):
    # 퇴사 날짜를 넘지 않으면
    if T[i] <= N - i:
        # 현재 날짜의 일을 수락했을때 vs 그 날짜에 벌써 저장된 보상과 비교
        dp[i+T[i]] = max(dp[i+T[i]], dp[i]+P[i])
        # print(dp)
    
    # 전날까지 일했던 보상과 다음날 보상 비교해서 최대값으로 저장
    dp[i+1] = max(dp[i+1], dp[i])


print(dp[-1])