"""
1. 문제접근
    set에 문자열을 추가한 후,
    검사대상 문자열이 set에 존재하는지 확인해서 풀었습니다.

2. 성능
    Runtime: 152ms
    Memory Usage: 35340KB
"""
import sys
input = sys.stdin.readline


def main():
    N, M = map(int, input().split())

    S = set()

    for _ in range(N):
        S.add(input())

    cnt = 0

    for _ in range(M):
        if input() in S:
            cnt += 1

    print(cnt)


if __name__ == '__main__':
    main()
