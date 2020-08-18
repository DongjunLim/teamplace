from itertools import permutations
import copy
import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())
A = [ list(map(int, input().split())) for _ in range(N) ]
R = [ list(map(int, input().split())) for _ in range(K) ]

least = float('inf')

def rotate(arr, y, x, n, m):
    rot_arr = arr
    rot_slice = []
    # 슬라이싱할 배열의 위치정보
    point = [(y, y+1, x, m-1), (y, n-1, m-1, m), (n-1, n, x+1, m), (y+1, n, x, x+1)]
    # 진행할 방향 (위, 오른쪽, 아래, 왼쪽 )
    direction = [(0,1),(1,0),(0,-1),(-1,0)]

    # 4개의 방향으로 제일 바깥 값들 얻어옴
    for i, d in enumerate(point):
        if i % 2 == 0:
            get = rot_arr[d[0]][d[2]:d[3]]
        else:
            get = []
            for dy in range(d[0], d[1]):
                get.append(rot_arr[dy][d[2]])

        rot_slice.append(copy.copy(get))

    for i, val in enumerate(zip(rot_slice, point, direction)):
        # 저장할 슬라이싱 배열의 위치정보
        dt = [ val[1][i]+ val[2][i//2] for i in range(4) ]
        result = rot_slice[i]

        if i % 2 == 0:
            rot_arr[dt[0]][dt[2]:dt[3]] = result
        else:
            j = 0
            for dy in range(dt[0], dt[1]):
                rot_arr[dy][dt[2]] = result[j]
                j += 1

    return rot_arr


for pr in permutations(R, K):
    copyA = copy.deepcopy(A)

    # 순차적으로 안으로 들어가면서 회전
    for r in pr:
        i = 0
        while True:
            dy = (r[0]-r[2]+i-1, r[0]+r[2]-i)
            dx = (r[1]-r[2]+i-1, r[1]+r[2]-i)

            # 종료조건
            if dx[0] >= dx[1] or dy[0] >= dy[1]:
                break

            rotate(copyA, dy[0], dx[0], dy[1], dx[1])
            i += 1

    for y in range(N):
        copyA_least = sum(copyA[y])
        least = copyA_least if least > copyA_least else least
        
print(least, end="")
