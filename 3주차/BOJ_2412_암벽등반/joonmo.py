import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[(x,y)] = 0
    # bfs 시작 index
    next_start_idx = 0
    while q:
        curr_x, curr_y = q.popleft()
        # 처음은 0부터 시작 그다음부터는 y좌표 2작은 곳부터 탐색
        for i in range(next_start_idx, len(wall)):
            tmp_x, tmp_y = wall[i]
            
            # y좌표 2작은 홈 인덱스 다음 탐색 시작부분으로 설정
            if (curr_y - tmp_y) ==2:
                next_start_idx = i
            
            # y좌표 2커지면 break
            if (tmp_y - curr_y) > 2:
                break

            # y좌표 2보다 더 작으면 continue
            if abs(curr_y - tmp_y) > 2:
                continue

            if wall[i] not in visited:
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