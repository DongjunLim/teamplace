import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')


# 섬들을 찾는데는 dfs 섬에서 섬까지 최소거리 찾는데는 bfs 활용했습니다

from collections import deque

# 지도출력 함수
def map_print(map):
    for i in map:
        print(i)

# 범위 확인 함수
def InBound(x,y):
    if 0 <= x < N and 0 <= y < N:
        return True
    else:
        return False

# dfs 로 섬 확인후 섬 좌표들 return
def dfs(y,x):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q = deque()
    q.append((y, x))
    visited[y][x] = True
    coord = [(y,x)]

    while q:
        curr_y, curr_x = q.pop()
        for i in range(4):
            tmp_x = curr_x + dx[i]
            tmp_y = curr_y + dy[i]

            if InBound(tmp_x, tmp_y):
                if my_map[tmp_y][tmp_x] == '1' and not visited[tmp_y][tmp_x]:
                    q.append((tmp_y, tmp_x))
                    visited[tmp_y][tmp_x] = True
                    coord.append((tmp_y, tmp_x))
        # print(q)
    return coord

# bfs로 하나의 섬 좌표들로 부터 다른 섬에 도달할때까지 최소값 return
def bfs(island):
    # print(island)
    q = deque()
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    for coord in island:
        q.append(coord)
    # print(q)

    # 바다 방문확인
    visited_sea = [[0 for _ in range(N)]for _ in range(N)]

    while q:
        curr_y, curr_x = q.popleft()
        for i in range(4):
            tmp_x = curr_x + dx[i]
            tmp_y = curr_y + dy[i]

            if InBound(tmp_x, tmp_y):
                # 기준점으로부터 주위점들이 벌써 내 섬땅이 아닌 땅일때 최소거리 return
                if my_map[tmp_y][tmp_x] == '1' and (tmp_y, tmp_x) not in island:
                    # map_print(visited_sea)
                    return visited_sea[curr_y][curr_x]
                # 그외에는 거리 저장
                if my_map[tmp_y][tmp_x] == '0' and visited_sea[tmp_y][tmp_x] == 0:
                    q.append((tmp_y, tmp_x))
                    visited_sea[tmp_y][tmp_x] = visited_sea[curr_y][curr_x] + 1



N = int(input())
my_map = []
for _ in range(N):
    my_map.append(input().split())
# map_print(my_map)

# 방문확인
visited = [[False for _ in range(N)]for _ in range(N)]

# map_print(visited)
island_num = 0
island_coord = []


for y in range(N):
    for x in range(N):
        if (my_map[y][x] == '1') and (not visited[y][x]):
            # print(x,y)
            island_coord.append(dfs(y, x))
            island_num += 1


# 출력
# print(island_num)
# print(island_coord)
bridges = []
for i in island_coord:
    bridges.append(bfs(i))

print(min(bridges))