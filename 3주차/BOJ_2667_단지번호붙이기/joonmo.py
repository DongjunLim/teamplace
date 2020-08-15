import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

# bfs로 단지확인
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

# 방문하지 않은 집 기준으로 단지확인
def find_complex(y,x):
    house_num = 1
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q = deque()
    q.append((y, x))
    visited[y][x] = True

    while q:
        curr_y, curr_x = q.popleft()
        for i in range(4):
            tmp_x = curr_x + dx[i]
            tmp_y = curr_y + dy[i]
            # 범위 안에 있고 시작점기준으로 옆에있는 집일때
            if InBound(tmp_x, tmp_y):
                if map[tmp_y][tmp_x] == '1' and not visited[tmp_y][tmp_x]:
                    q.append((tmp_y, tmp_x))
                    visited[tmp_y][tmp_x] = True
                    house_num += 1
        # print(q)
    return house_num


N = int(input())
map = []
for _ in range(N):
    map.append(input())
# map_print(map)

# 방문확인
visited = [[False for _ in range(N)]for _ in range(N)]
# map_print(visited)
complex_num = 0
house_nums = []

# 방문하지 않은 집찾기
for y in range(N):
    for x in range(N):
        # 집이면서 방문하지 않은곳에서 시작
        if (map[y][x] == '1') and (not visited[y][x]):
            # print(x,y)
            house_nums.append(find_complex(y, x))
            complex_num += 1


# 출력
print(complex_num)
house_nums.sort()
for i in house_nums:
    print(i)



