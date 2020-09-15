"""
1. 문제접근
	BFS로 풀었습니다.

2. 성능
	Runtime: 208ms
	Memory Usage: 37008KB
"""
from collections import deque
MAX = 100001


def main():
    N, K = map(int, input().split())

    print(solve(N, K))


def solve(n, k):
    queue = deque()

    visited = [False]*(MAX*2)

    queue.append([n, 0])

    while queue:
        now, cnt = queue.popleft()

        if now == k:
            return cnt

        if now + 1 < MAX and not visited[now + 1]:
            queue.append([now + 1, cnt + 1])
            visited[now + 1] = True

        if now - 1 >= 0 and not visited[now - 1]:
            queue.append([now - 1, cnt + 1])
            visited[now - 1] = True

        if now * 2 < MAX*2 and not visited[now*2]:
            queue.append([now*2, cnt + 1])
            visited[now*2] = True


if __name__ == "__main__":
    main()
