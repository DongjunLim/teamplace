# 트리로 푸는건줄알고 시간날리다 
# 생각해보니까 bfs 로 그냥 길찾기 처럼 풀면 나오는 문제였다.

import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

n = int(input())
a, b = map(int, input().split())
m = int(input())



tree = [[] for _ in range(n)]

for _ in range(m):
    x, y = map(int, input().split())
    tree[x-1].append(y)
    tree[y-1].append(x)
# print(tree)

def bfs(a,b):
    q = deque()
    visited = [a]
    q.append([a,0])

    while q:
        tmp, count = q.popleft()
        for i in tree[tmp-1]:
            if i == b:
                return count + 1
            else:
                if i not in visited:
                    q.append([i, count + 1])
                    visited.append(i)
    return -1

print(bfs(a,b))
