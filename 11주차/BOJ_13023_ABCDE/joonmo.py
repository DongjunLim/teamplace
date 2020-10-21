# https://hjp845.tistory.com/89 참고
# 이해하는데 오래 걸린문제
# 그래프에서 경로가 4이상 있으면 1 출력하면 되는 문제
# dfs 사용
# while 문으로 dfs 했는데 실패
# 다시 풀어볼것

import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

N, M = map(int, input().split())
# print(N, M)
graph = [ [] for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for i in range(N)]

def dfs(start, depth):
    global ans

    # 시작점 방문
    visited[start] = True

    # 깊이 4이상 Ture
    if depth >=4:
        ans = True
        return

    # 다음 경로 찾기
    for nxt in graph[start]:
        # 방문안한곳일때
        if not visited[nxt]:
            # 재귀로 dfs
            dfs(nxt, depth + 1)
            # dfs 들어갔던곳 다시 올라올때 방문 처리 되돌려놓기
            visited[nxt] = False    

# ans 초기화
# 초기화 안해줬더니 틀렸는데 어떤건 맞고 어떤건 왜 안맞는지 잘 모르겠다
ans = False

# 모든 점 시작점으로 dfs 실행
for i in range(N):
    dfs(i,0)
    visited[i] = False
    if ans:
        break

print(1 if ans else 0)



