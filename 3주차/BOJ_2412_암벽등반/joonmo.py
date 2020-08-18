import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[(x,y)] = 0
    while q:
        curr_x, curr_y = q.popleft()
        for i in wall:
            if i not in visited:
                tmp_x, tmp_y = i
                if abs(curr_x - tmp_x) <= 2 and abs(curr_y - tmp_y) <= 2:
                    if tmp_y == T:
                        return visited[(curr_x, curr_y)] + 1
                    else:
                        q.append((tmp_x, tmp_y))
                        visited[(tmp_x, tmp_y)] = visited[(curr_x, curr_y)] + 1
        # print(q)
        # print(visited)
    return -1

n, T = map(int, input().split())
# print(n,T)

wall = []
visited = dict()
for i in range(n):
    x,y = map(int, input().split())
    wall.append((x,y))

wall = sorted(wall, key = lambda x: (x[1], x[0]))
# print(wall)

print(bfs(0, 0))