import os
import sys
import math

file_dr = os.path.abspath(__file__)
curr_dr = os.path.dirname(file_dr)
sys.stdin = open(curr_dr + "\input.txt", "r")

# bfs 사용하서 풀이

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

    # 모든 약수 구하기
    divisor_lst = get_divisor(X)
    # print(X)
    # print('divisors = ', divisor_lst)
    

    # 입력가능한 약수 구하기
    possible_divisors =[]
    
    for i in divisor_lst:
        if check_input(i):
            possible_divisors.append(i)
    
    # print('poss divisors = ', possible_divisors)
    
    if 1 in possible_divisors:
        possible_divisors.remove(1)
    
    # print('poss divisors = ', possible_divisors)

    # 입력가능 약수 없을때 -1 출력
    if len(possible_divisors) == 0:
        return -1

    # # 입력가능 약수 1개일때
    # elif len(possible_divisors) == 1:
    #     # 입력 가능한게 1밖에 없을때 -1 출력
    #     if 1 in possible_divisors:
    #         return -1

    ans_lst = []
    # 숫자 바로 입력가능할 경우
    if X in possible_divisors:
        answer = len(str(X))+1
        return answer
    
    # 숫자 바로 입력 불가능한 경우
    else:
        # 입력가능한 약수가 존재할 때
        for i in possible_divisors:
            # 짝지은 약수도 입력가능할 때
            if X//i in possible_divisors:
                answer = len(str(i)) + len(str(X//i)) + 2
                return answer
            # 짝지은 약수가 입력 불가능할 때
            else:
                tmp = bfs(X//i)
                if tmp == -1:
                    return -1
                else:
                    answer =  len(str(i)) + 1 + tmp
                    return answer
    
    # 답 경우의 수가 많을 때 더 적게 입력할 수 있는 경우 존재 여부?
    # print(ans_lst)
    # return min(ans_lst)

T = int(input())
for test_case in range(1, T + 1):

    avail_num = []
    button = list(map(int, input().split()))
    # print(button)
    
    for i in range(9,-1,-1):
        if button[i]==1:
            avail_num.append(i)
    # print('input able num = ', avail_num)

    X = int(input())
    # print(X)

    print('#%d %d' % (test_case, bfs(X)))


    
