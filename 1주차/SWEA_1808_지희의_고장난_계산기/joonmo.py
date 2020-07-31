
import sys
sys.stdin = open("D:/GitHub/teamplace/teamplace/1주차/SWEA_1808_지희의_고장난_계산기/input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):

    avail_num = []
    button = list(map(int, input().split()))
    
    for i in range(9,0,-1):
        if button[i]==1:
            avail_num.append(i)
    print(avail_num)

    goal = int(input())
    print(goal)

    answer = 0

    for i in avail_num:
        tmp = goal//i
        answer += tmp
        print(tmp)

    if answer == 0:
        print('#%d %d' % (test_case,-1))
    else:
        print('#%d %d' % (test_case,answer))

    
