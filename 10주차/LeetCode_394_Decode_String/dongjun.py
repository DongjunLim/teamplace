'''
1. 문제접근
    재귀로 풀었습니다. 중복되는 코드가 있어 따로 함수로 빼려고 했는데 쉽지 않네요..
    시간 날 때 리팩토링 하겠습니다.
    
2. 성능
    Runtime: 20ms
    Memory Usage: 13.9MB
    Time Complexity: O(N)
'''
class Solution:    
    def decodeString(self, s: str) -> str:
        num = []
        idx = 0
        
        ret = ''
        while idx < len(s):
            if s[idx].isdigit():
                num.append(s[idx])
            elif s[idx] == '[':
                idx, decode_str = self.decode(int(''.join(num)), idx + 1, s)
                num = []
                ret += decode_str
                continue
            elif s[idx] != ']':
                ret += s[idx]
                
            idx += 1
        
        return ret
    
    
    def decode(self, cnt, current_idx, s):
        num = []
        ret = ''
        
        while s[current_idx] != ']':
            if s[current_idx].isdigit():
                num.append(s[current_idx])
            elif s[current_idx] == '[':
                current_idx, decode_str = self.decode(int(''.join(num)), current_idx + 1, s)
                num = []
                ret += decode_str
                continue
            else:
                ret += s[current_idx]
            current_idx += 1
        
        return current_idx + 1, ret*cnt
