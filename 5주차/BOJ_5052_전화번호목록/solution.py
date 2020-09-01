import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

# list를 sort하고 바로 다음 번호와 비교했을때 앞이 같으면 일관성이 없다.

def check(lst):
    for idx in range(len(lst)-1):
                
        # 처음에 in 으로 확인했는데 100 퍼센트에서 계속 틀렸다해서 빡침
        # 생각해보니까 앞에서부터 같아야되는데 중간에 포함되있으면 틀려서 in 으로 하면 안됨
        # if lst[idx] in lst[idx+1]

        # 맨앞 중복확인
        if lst[idx] == lst[idx+1][0:len(lst[idx])]:
            return False
    return True



t = int(input())
answer = []
for _ in range(t):
    n = int(input())
    num_list = []
    for _ in range(n):
        num_list.append(input())
    num_list.sort()
    
    if check(num_list):
        print('YES')
    else:
        print('NO')
