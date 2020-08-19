enable_set = {str(x) for x in range(10)}

N = int(input())
M = int(input())
if (M == 0):
    pass
else:
    break_set = set(input().split())
    enable_set -= break_set

result = abs(N - 100)
for i in range(1000001):
    is_true = True
    for part_num in str(i):
        if (part_num not in enable_set):
            is_true = False
            break
    if is_true is True:
        result = min(result, abs(N - i) + len(str(i)))

print(result)
