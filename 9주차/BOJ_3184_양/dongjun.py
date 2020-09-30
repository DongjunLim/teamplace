"""
1. 문제접근
    BFS를 사용해 풀었습니다.
    울타리 내부를 돌면서 양과 늑대의 갯수를 카운트 했습니다.

2. 성능
    Runtime: 212ms
    Memory Usage: 32496KB
"""

import sys
from collections import deque
input = sys.stdin.readline


def main():
    R, C = map(int, input().split())

    board = [list(input()) for _ in range(R)]

    aliveLames, aliveWolves = solve(R, C, board)

    print(aliveLames, aliveWolves)


def solve(R, C, board):
    search = search_area(R, C, board)
    aliveLambs, aliveWolves = 0, 0
    
    for i in range(R):
        for j in range(C):
            lambs, wolves = search(i, j)
            aliveLambs += lambs
            aliveWolves += wolves

    return aliveLambs, aliveWolves


def search_area(R, C, board):
    visited = [[False] * C for _ in range(R)]
    DIRECTION = ((0, 1), (1, 0), (-1, 0), (0, -1))

    def is_same_area(r, c):
        if -1 < r < R and -1 < c < C and board[r][c] != '#':
            return True
        return False

    def inner(r, c):
        if visited[r][c] or board[r][c] == '#':
            return 0, 0

        lambs = 0
        wolves = 0

        queue = deque()
        queue.append((r, c, board[r][c]))

        visited[r][c] = True

        while queue:
            row, col, now = queue.popleft()

            if now == 'o':
                lambs += 1
            elif now == 'v':
                wolves += 1

            for x, y in DIRECTION:
                nr = row + x
                nc = col + y
                if is_same_area(nr, nc) and not visited[nr][nc]:
                    visited[nr][nc] = True
                    queue.append((nr, nc, board[nr][nc]))

        if lambs > wolves:
            wolves = 0
        else:
            lambs = 0

        return lambs, wolves

    return inner


if __name__ == '__main__':
    main()
