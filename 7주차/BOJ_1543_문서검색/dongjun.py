"""
1. 문제접근
    그리디하게 앞에서부터
    확인하며 풀었습니다.

2. 성능
    Runtime: 64ms
    Memory Usage: 29380KB
"""


def main():
    string = input()
    target = input()

    print(solve(string, target))


def solve(string, target):
    length = len(target)
    cnt = 0
    idx = 0

    while idx < len(string) - length + 1:
        if target == string[idx:idx+length]:
            cnt += 1
            idx += length
        else:
            idx += 1

    return cnt


if __name__ == "__main__":
    main()
