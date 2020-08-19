import os
import sys
curr_dir = os.path.dirname(__file__)
sys.stdin = open(curr_dir + '\input.txt', 'r')

# 브루트포스 사용

# 주어진 숫자가 입력가능한 채널인지 확인하는 함수
def pushable(ch):
    for i in str(ch):
        if int(i) not in num:
            return False
    return True

num = [i for i in range(10)]

# 목표채널, 누르지 못하는 숫자
N = int(input())
broken_num = int(input())

# 고장난 버튼이 0개일때는 input을 받지 않고 그 외에는 input을 받고 0부터9에서 빼준다
if broken_num != 0:
    broken_num_lst = list(map(int, input().split()))
    for i in broken_num_lst:
        if i in num:
            num.remove(i)

# 모든 버튼이 고장나지 않았을때는 목표 채널 기준으로 큰채널 작은 채널을 확인해서 입력가능한 가장 가까운 채널을 찾아준다.
if broken_num < 10:
    
    # 목표채널로부터 차이
    diff = 0

    while True:
        # 숫자의 자릿수가 작을 때가 더 최적이기 때문에 작은 숫자부터 확인
        tmp_ch = N - diff
        
        # 채널이 0 밑으로 내려가는지 확인, 입력가능한지 확인
        if tmp_ch >= 0 and pushable(tmp_ch) :
            closest_ch = tmp_ch
            break

        # 차이만큼 큰 숫자 확인
        tmp_ch = N + diff
        if pushable(tmp_ch):
            closest_ch = tmp_ch
            break
        diff += 1

    # 100에서 직접 움직일때와 가까운 채널에서 움직일 때 중 더 적은 수로 답 출력
    ans1 = len(str(closest_ch)) + abs(N - closest_ch)
    ans2 = abs(N - 100)
    print(min(ans1, ans2))
    
# 모든 버튼이 고장났을때는 바로 100에서 이동하는 수를 세어준다
else:
    print(abs(N - 100))

