"""
1. 문제접근
    BFS를 사용해 풀었습니다.

2. 성능
    Runtime: 616ms
    Memory Usage: 32488KB
"""

import sys
from collections import deque

input = sys.stdin.readline

DIRECTION = [[0, 1], [1, 0], [0, -1], [-1, 0]]


def main():
    R, C = map(int, input().split())
    board = [list(input()[:-1]) for _ in range(R)]

    print(solve(R, C, board))


def solve(rowLen, colLen, board):
    global DIRECTION

    queue = deque()
    time = [False] * 1000
    visited = [[False] * colLen for _ in range(rowLen)]

    sr, sc = get_start_point(board)

    queue.append([sr, sc, 0])

    visited[sr][sc] = True

    while queue:
        row, col, nowTime = queue.popleft()

        if board[row][col] == 'D':
            return nowTime

        if not time[nowTime]:
            spread_water(board)
            time[nowTime] = True

        for dt in DIRECTION:
            nr = row + dt[0]
            nc = col + dt[1]

            if check_idx_out_of_range(nr, nc, rowLen, colLen) \
                    and not visited[nr][nc] \
                    and (board[nr][nc] == '.' or board[nr][nc] == 'D'):
                queue.append([nr, nc, nowTime + 1])
                visited[nr][nc] = True

    return "KAKTUS"


def get_start_point(board):

    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 'S':
                return i, j


def spread_water(board):
    global DIRECTION

    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == '*':
                for dt in DIRECTION:
                    nr = i + dt[0]
                    nc = j + dt[1]

                    if check_idx_out_of_range(nr, nc,
                                              len(board), len(board[i])) \
                            and board[nr][nc] == '.':
                        board[nr][nc] = '@'

    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == '@':
                board[i][j] = '*'


def check_idx_out_of_range(row, col, rowLen, colLen):
    if 0 <= row < rowLen and 0 <= col < colLen:
        return True
    return False


if __name__ == "__main__":
    main()

