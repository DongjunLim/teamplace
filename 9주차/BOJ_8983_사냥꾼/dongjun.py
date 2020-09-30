"""
1. 문제접근
    투포인터를 사용해 풀었습니다.

2. 성능
    Runtime: 412ms
    Memory Usage: 50640KB
    시간복잡도: O(nlogn) <- 정렬시간
"""

import sys
input = sys.stdin.readline


def main():
    M, N, L = map(int, input().split())

    saro = list(map(int, input().split()))
    animals = [list(map(int, input().split())) for _ in range(N)]

    print(solve(M, N, L, saro, animals))


def solve(M, N, L, saro, animals):
    saro.sort()
    animals.sort()

    cnt = 0
    left = 0
    for i, point in enumerate(animals):
        x, y = point
        if L < y:
            continue

        left, right = find_close_point(left, x, M, saro)

        minPoint = x - (L - y)
        maxPoint = x + (L - y)

        if is_shot(minPoint, maxPoint, left, right, x, saro):
            cnt += 1

    return cnt


def find_close_point(saroPoint, animalPoint, length, saro):
    while saroPoint < length - 1 and saro[saroPoint + 1] < animalPoint:
        saroPoint += 1

    return saroPoint, saroPoint + 1


def is_shot(mnp, mxp, left, right, x, saro):
    if x < saro[left]:
        if saro[left] <= mxp:
            return True
    elif right < len(saro) and x > saro[right]:
        if mnp <= saro[right]:
            return True
    elif mnp <= saro[left] or (right < len(saro) and mxp >= saro[right]):
        return True

    return False


if __name__ == '__main__':
    main()
