import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

# 모든 부분집합 경우의수를 구했습니다.
from itertools import combinations

N, S = map(int, input().split())
lst = list(map(int, input().split()))

count = 0

for i in range(1, N+1):
    sub_lst = combinations(lst,i)
    tmp = 0
    for j in sub_lst:
        if sum(j) == S:
            count +=1

print(count)