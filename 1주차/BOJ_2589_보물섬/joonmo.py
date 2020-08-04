import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

def map_print(map):
    for i in map:
        print(i)

def InBound(x,y):
    if 0 <= x < col and 0 <= y < row:
        return True
    else:
        return False

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x,y):
    # print(x,y)
    q.append((x,y))
    time = [[0]*col for _ in range(row)]
    time[y][x] = 1
    # map_print(time)
    max_time = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            tmp_y = y + dy[i]
            tmp_x = x + dx[i]
            if InBound(tmp_x, tmp_y):
                if map[tmp_y][tmp_x] == 'L' and time[tmp_y][tmp_x] == 0:
                    time[tmp_y][tmp_x] = time[y][x] + 1
                    max_time = max(max_time, time[tmp_y][tmp_x])
                    q.append((tmp_x,tmp_y))
        # print()
        # map_print(time)
    # print(max_time-1)
    return max_time-1



row, col = map(int, input().split())
# print(row,col)
map = [input() for _ in range(row)]
# map_print(map)
q = deque()

dist = []

answer = 0 
for x in range(col):
    for y in range(row):
        if map[y][x] == 'L':
            answer = max(answer, bfs(x,y))

print(answer)