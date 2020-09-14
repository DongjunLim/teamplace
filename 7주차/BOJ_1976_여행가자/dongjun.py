"""
1. 문제접근
    union-find 로 풀었습니다.
    이동할 수 있는 모든 경로를 같은 집합으로 합치고,
    여행경로를 순회하며 집합이 같은지 검사합니다.
    집합이 다르다면, 이동이 불가능한 것이기 때문에
    NO를 반환합니다.

2. 성능
    Runtime: 72ms
    Memory Usage: 29508KB
"""

import sys

input = sys.stdin.readline
disjointSet = []


def main():
    N = int(input())
    M = int(input())

    cities = [list(map(int, input().split())) for _ in range(N)]

    route = list(map(int, input().split()))

    print(solve(cities, route))


def solve(cities, route):
    global disjointSet

    disjointSet = [-1] * len(cities)

    for i, city in enumerate(cities):
        for j, cityNum in enumerate(city):
            if i == j:
                continue
            if cityNum == 1:
                union(i, j)

    setNum = find_set(route[0]-1)

    for rt in route[1:]:
        if find_set(rt - 1) != setNum:
            return "NO"

    return "YES"


def union(u, v):
    global disjointSet

    parent1 = find_set(u)
    parent2 = find_set(v)

    if parent1 != parent2:
        disjointSet[parent2] = parent1
    return


def find_set(node):
    global disjointSet

    if disjointSet[node] < 0:
        return node
    disjointSet[node] = find_set(disjointSet[node])

    return disjointSet[node]


if __name__ == "__main__":
    main()
