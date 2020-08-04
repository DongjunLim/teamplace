import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

def maze_print(map):
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
    dist = [[0]*col for _ in range(row)]
    dist[y][x] = 1
    # map_print(time)
    max_time = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            tmp_y = y + dy[i]
            tmp_x = x + dx[i]
            if InBound(tmp_x, tmp_y):
                # print(tmp_y + 1, tmp_x + 1)
                # print(row, col)
                if maze[tmp_y][tmp_x] == '1' and dist[tmp_y][tmp_x] == 0:
                    dist[tmp_y][tmp_x] = dist[y][x] + 1
                    if tmp_y + 1 == row and tmp_x + 1 == col:
                        return dist[tmp_y][tmp_x]
                    else:
                        q.append((tmp_x,tmp_y))
                        # maze_print(dist)
                        # print()
                



row, col = map(int, input().split())
maze = [input() for _ in range(row)]
# maze_print(maze)
q = deque()

dist = []
answer = bfs(0,0)

print(answer)