import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

from collections import deque

# 4자리수 소수 모두 저장

def isPrime(a):
    if(a<2):
        return False
    for i in range(2,a):
        if(a%i==0):
            return False
    return True

primes = []

for i in range(1000, 9999):
    if isPrime(i):
        primes.append(i)

# print(len(primes))


# bfs로 모든 자리수 하나씩 바꾸고 소수일시 q 에 넣어서 bfs 실행
def bfs(A, n):
    check = []
    check.append(A)
    q = deque()
    q.append((A,n))
    while q:
        curr_num, tmp_n = q.popleft()
        if curr_num == B:
            return tmp_n
        else:
            curr_num = str(curr_num)
            for num in range(10):
                for digit in range(4):

                    # 첫재짜리 0은 제외
                    if digit == 0 and num == 0:
                        continue
                    tmp_num = curr_num[:digit] + str(num) + curr_num[digit+1:]
                    tmp_num = int(tmp_num)
                    
                    if (tmp_num in primes) and (tmp_num not in check):
                        q.append((tmp_num, tmp_n + 1))
                        check.append(tmp_num)
                        # print((tmp_num,tmp_n+1), end = ' ')
                    else:
                        continue
        # print(q) 
    

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    print(bfs(A, 0))