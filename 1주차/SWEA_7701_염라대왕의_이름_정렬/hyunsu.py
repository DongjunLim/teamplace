T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    
    # 리스트 컴프리헨션을 활용해서 일괄 작업 - set로 중복 제거
    dead_list = list(set([ input().rstrip() for _ in range(N) ]))
    # 사전순, 길이순 순서대로
    dead_list.sort()
    dead_list.sort(key=len)
    
    print('#' + str(test_case))
    for name in dead_list:
        print(name)