from collections import deque
import sys

N = int(sys.stdin.readline())

maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dirs = [(1,0),(0,1),(-1,0),(0,-1)]
visited = [ [False] * N for _ in range(N) ]
ocean = []
idx = 0

def grouping(x, y):
    queue = deque()

    queue.append([x, y])
    ocean.append([])

    visited[y][x] = True
    maps[y][x] = idx+1

    while queue:
        X, Y = queue.popleft()

        for i in range(4):
            dx = dirs[i][0] + X
            dy = dirs[i][1] + Y

            if 0 <= dx < N and 0 <= dy < N and not visited[dy][dx] and maps[dy][dx] != 0:
                maps[dy][dx] = idx+1
                visited[dy][dx] = True
                queue.append([dx, dy])

            elif 0 <= dx < N and 0 <= dy < N and maps[dy][dx] == 0 and [X, Y] not in ocean[idx]:
                ocean[idx].append([X, Y, 0])


def minLength():
    min_ = 1000

    queue = deque()
    for id_ in range(idx-1):
        queue.clear()
        queue.extend(ocean[id_])
        
        while queue:
            X, Y, count = queue.popleft()

            if min_ >= count:
                for i in range(4):
                    dx = dirs[i][0] + X
                    dy = dirs[i][1] + Y

                    if 0 <= dx < N and 0 <= dy < N and visited[dy][dx] != id_+1 and maps[dy][dx] == 0:
                        visited[dy][dx] = id_ + 1
                        queue.append([dx, dy, count+1])
                    elif 0 <= dx < N and 0 <= dy < N and maps[dy][dx] != 0 and maps[dy][dx] != id_+1:
                        min_ = min(min_, count)

    print(min_)

for y in range(N):
    for x in range(N):
        if not visited[y][x] and maps[y][x] == 1:
            grouping(x, y)
            idx += 1

minLength()
