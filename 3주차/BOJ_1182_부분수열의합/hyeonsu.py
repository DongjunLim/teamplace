from itertools import combinations
from functools import reduce

N, S = map(int, input().split())
integer = list(map(int, input().split()))
count = 0

for i in range(1, len(integer) + 1):
    lst = list(combinations(integer, i))
    val = [ reduce(lambda x, y: x+y, l) for l in lst ]
    count += len(list(filter(lambda x: x == S, val)))
    
print(count)
