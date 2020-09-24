"""
1. 문제접근
    동적계획법을 사용해 풀었습니다.

2. 성능
    Runtime: 252ms
    Memory Usage: 127964KB
    시간복잡도: O(nlgn)
"""


def main():
    n = int(input())

    print(solve(n))


def solve(n):
    dp  = [i for i in range(n + 1)]

    for i in range(2, n + 1):
        j = 2
        while j**2 <= i:
            dp[i] = min(dp[i], dp[i - j**2] + 1)
            j += 1
    return dp[n]


if __name__ == '__main__':
    main()
