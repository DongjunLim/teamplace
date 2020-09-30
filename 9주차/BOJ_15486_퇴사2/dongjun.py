"""
1. 문제접근
    동적계획법으로 풀었습니다.

2. 성능
    Runtime: 2992ms
    Memory Usage: 249288KB
"""
import sys
input = sys.stdin.readline


def main():
    N = int(input())

    schedules = [tuple(map(int, input().split())) for _ in range(N)]

    print(solve(N, schedules))


def solve(n, schedules):
    TIME, PAY = 0, 1

    dp = [0] * (n+1)

    ret = 0

    for now in range(n):
        ret = max(ret, dp[now])
        if now + schedules[now][0] > n + 1:
            continue

        dp[schedules[now][TIME] + now] = max(ret + schedules[now][PAY], dp[schedules[now][TIME] + now])

    return max(dp[n], ret)


if __name__ == '__main__':
    main()
