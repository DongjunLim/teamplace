"""
1. 문제접근
    재귀로 풀었습니다.

2. 성능
    Runtime: 1168ms
    Memory Usage: 103664KB
    시간복잡도: O(2^N)
"""
def main():
    n = int(input())

    solve(n)


def solve(n):
    ret = []

    def hanoi(n, frm, target, temp):
        nonlocal ret

        if n == 1:
            ret.append((frm, target))
            return

        hanoi(n - 1, frm, temp, target)
        ret.append((frm, target))
        hanoi(n - 1, temp, target, frm)

    hanoi(n, 1, 3, 2)

    print(len(ret))
    for f, t in ret:
        print(f, t)


if __name__ == '__main__':
    main()
