# 점수들을 리스트에 넣어준다
# 거꾸로 돈다
# 바로 전 점수보다 1 낮게 만들어준다
# 차를 합산해서 print 한다

import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

N = int(input())
points = []

for i in range(N):
    points.append(int(input()))

# print(points)
answer = 0
tmp = None
for idx in range(N-1, -1, -1):
    if tmp is None:
        tmp = points[idx]
    else:
        if points[idx] >= tmp:
            diff = points[idx] - tmp
            points[idx] -= diff+1
            # print(diff)
            answer += diff + 1
            tmp = points[idx]
        else:
            tmp = points[idx]
    # print(points)

print(answer)