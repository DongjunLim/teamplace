# 두번 정렬 실행
# 1. 중복 제거
# 2. 알파벳 순 정렬
# 3. 단어 길이 순 정렬


T = int(input())

for test_case in range(1, T + 1):

    N = int(input())
    name_lst = []

    # list에 단어 넣기
    for _ in range(N):
        name_lst.append(input())
    # print(name_lst)

    # set 사용해 중복 제거
    name_lst = list(set(name_lst))
    # print(name_lst)
    
    # 알파벳 순 정렬
    name_lst.sort()

    # 단어 길이 순 정렬
    sorted_lst = sorted(name_lst, key = lambda x : len(x))

    print('#%d' % test_case)
    for i in sorted_lst:
        print(i)
