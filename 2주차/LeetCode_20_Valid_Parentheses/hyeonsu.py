#Runtime: 32 ms
#Memory Usage: 13.9 MB
#O(N)

class Solution:
    def isValid(self, s: str) -> bool:
        bracket = []
        valid = [('(',')'),('{','}'),('[',']')]
        
        for c in s:
        	# (, {, [ 해당하면 bracket 넣기
            if any(c == brac[0] for brac in valid):
                bracket.append(c)
            
            else:
            	# '(', ')' 서로 일치하는지 확인, 맞으면 pop 아니면 False
                if bracket and any((bracket[-1] == brac[0] and c == brac[1]) for brac in valid):
                    bracket.pop()
                else:
                    return False
        
        # ')' 한 가지의 케이스나 예외 생각해서 bracket이 비어있으면 True, 있으면 False
        if not bracket: return True
        else: return False
