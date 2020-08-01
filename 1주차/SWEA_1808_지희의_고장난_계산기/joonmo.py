import os
import sys
import math

file_dr = os.path.abspath(__file__)
curr_dr = os.path.dirname(file_dr)
sys.stdin = open(curr_dr + "\input.txt", "r")

def get_divisor(num):
    divisors = []
    length = int(math.sqrt(num)) + 1

    for i in range(1,length):
        if num % i == 0:
            divisors.append(i)
            divisors.append(num//i)
    
    divisors.sort(reverse=True)
    return divisors

def check_input(num):
    for i in str(num):
        tmp = int(i)
        # print(tmp)
        if tmp not in avail_num:
            # print('impossible')
            return False
    # print('possible')
    return True

def bfs(X):
    divisor_lst = get_divisor(X)
    # print(divisor_lst)
    
    possible_divisors =[]
    
    for i in divisor_lst:
        if check_input(i):
            possible_divisors.append(i)
    
    print(possible_divisors)
    
    if len(possible_divisors) == 0:
        return -1
    elif len(possible_divisors) == 1:
        if 1 in possible_divisors:
            return -1

    ans_lst = []
    if X in possible_divisors:
        answer = len(str(X))+1
        return answer
    else:
        for i in possible_divisors:
            if X//i in possible_divisors:
                answer = len(str(i)) + len(str(X//i)) + 2
                return answer
            else:
                answer =  len(str(i)) + 1 + bfs(X//i)
                ans_lst.append(answer)

    print(ans_lst)
    return min(ans_lst)

T = int(input())
for test_case in range(1, T + 1):

    avail_num = []
    button = list(map(int, input().split()))
    
    for i in range(9,0,-1):
        if button[i]==1:
            avail_num.append(i)
    print(avail_num)

    X = int(input())
    print(X)

    # divisor_lst = get_divisor(X)
    # print(divisor_lst)

    # possible_divisors =[]
    
    # for i in divisor_lst:
    #     if check_input(i):
    #         possible_divisors.append(i)
    
    # print(possible_divisors)

    # if len(possible_divisors) == 0:
    #     answer = 0

    # if X in possible_divisors:
    #     answer = len(str(X))+1
    # else:
    #     for i in possible_divisors:
    #         if X//i in possible_divisors:
    #             answer = len(str(i)) + len(str(X//i)) + 2
    #             break
    #         else:
    #             answer = 0



    print('#%d %d' % (test_case, bfs(X)))


    
