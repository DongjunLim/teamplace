'''
1. 문제접근
    dfs로 풀었습니다.

2. 성능
    Runtime: 1280ms
    Memory Usage: 29380KB
    시간복잡도: O(N^3)?
'''
import sys
input = sys.stdin.readline


def main():
    N, M = map(int, input().split())

    relationship = [tuple(map(int, input().split())) for _ in range(M)]

    print(solve(N, M, relationship))


def solve(n, m, relationship):
    adj_list = [[] for _ in range(n)]
    visited = [False] * n

    for a, b in relationship:
        adj_list[a].append(b)
        adj_list[b].append(a)

    def dfs(now, cnt):
        nonlocal adj_list, visited
        if cnt == 4:
            print(1)
            return exit(0)

        visited[now] = True
        friends = adj_list[now]

        for friend in friends:
            if not visited[friend]:
                dfs(friend, cnt + 1)

        visited[now] = False

    for person in range(n):
        dfs(person, 0)

    return 0


if __name__ == '__main__':
    main()
