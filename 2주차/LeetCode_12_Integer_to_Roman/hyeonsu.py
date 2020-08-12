#Runtime: 56 ms
#Memory Usage: 13.9 MB

class Solution:
    def intToRoman(self, num: int) -> str:
        value = [1000, 500, 100, 50, 10, 5, 1]
        val = [0] * 7
        symbol = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
        output = ""
        
        for idx in range(0,7,2):
            # 1000부터 각 몫을 구하되, 5 단위는 구하지 않음
            val[idx] = num // value[idx]
            num = num % value[idx]
            sym = symbol[idx]    # 심볼 문자
            
            # I, X, C 문자일 경우
            if any(rule == sym for rule in ['I', 'X', 'C']):
            	# 4와 9일 때
                if val[idx] == 4 or val[idx] == 9:
                    output += sym + symbol[idx - (val[idx]//4)]
                # 9가 아니고, 5이상일 때
                elif val[idx] >= 5:
                    output += symbol[idx-1] + sym * (val[idx] - 5)
                else:
                    output += sym * val[idx]
            else:
                output += sym * val[idx]
                
        return output
        
