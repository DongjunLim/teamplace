import os
import sys

curr_dr = os.path.dirname(__file__)
sys.stdin = open(curr_dr + '\input.txt' , 'r')

T = int(input())
A = list(map(int, input().split()))
dp = [x for x in A]

# print(dp)

for i in range(T):
    for j in range(i):
        if A[i] > A[j]:
            dp[i] = max(dp[i], dp[j] + A[i])
    # print(dp)

print(max(dp))

