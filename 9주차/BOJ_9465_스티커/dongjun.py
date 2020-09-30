"""
1. 문제접근
    동적계획법으로 풀었습니다.
    현재 스티커를 포함하는 경우와 포함하지 않는 경우로 나눠 둘 중에 큰 값을 저장하여 풀었습니다.

2. 성능
    Runtime: 796ms
    Memory Usage: 39768KB
"""
def main():
    T = int(input())

    for tc in range(1, T+1):
        n = int(input())
        stickers = [list(map(int, input().split())) for _ in range(2)]
        print(solve(n, stickers))


def solve(n, stickers):
    TOP, BOTTOM = 0, 1
    dp = [[0]*n for _ in range(2)]
    dp[TOP][0] = stickers[TOP][0]
    dp[BOTTOM][0] = stickers[BOTTOM][0]

    for i in range(1, n):
        dp[TOP][i] = max(stickers[TOP][i] + dp[BOTTOM][i-1], dp[TOP][i-1])
        dp[BOTTOM][i] = max(stickers[BOTTOM][i] + dp[TOP][i-1], dp[BOTTOM][i-1])

    return max(dp[TOP][n-1], dp[BOTTOM][n-1])


if __name__ == '__main__':
    main()
