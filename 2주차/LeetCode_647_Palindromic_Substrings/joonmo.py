# Runtime: 484 ms
# Memory Usage: 21.1 MB

# 2차원 배열을 만들고 palindrome 확인을 dp로 확인하였습니다.

class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)

        # substring이 palindrome인지 확인해주는 2차원 배열
        dp_arr = [[False for _ in range(length)] for _ in range(length)]

        count = 0

        # dp[word_len][start_idx] 에서 word_len은 단어길이 -1 
        # start_idx는  substring이 시작하는 index
        for word_len in range(length):
            for start_idx in range(length):
                
                # 단어 길이가 1일때 무조건 True
                if word_len == 0:
                    dp_arr[0][start_idx] = True
                    count += 1

                # 단어 길이가 2일때는 두 글자가 같을 때 True
                elif word_len == 1:
                    if start_idx + 1 < length:
                        if s[start_idx] == s[start_idx+1]:
                            dp_arr[1][start_idx] = True
                            count += 1

                # 단어 길이가 3이상시 맨앞 맨뒤 글자가 같고 그 가운데 word_len-2길이 substring이 palindrome 이면 True
                elif word_len > 1:
                    if start_idx + word_len < length:
                        if s[start_idx] == s[start_idx + word_len] and dp_arr[word_len-2][start_idx+1]:
                            dp_arr[word_len][start_idx] = True
                            count+=1

        return count
                 


    # runtime error 나왔을 때
    
    # length = len(s)
    
    # def palindromic(s):
    #     tmp_length = len(s)
    #     for i in range(tmp_length//2):
    #         if s[i] != s[-i-1]:
    #             return False
    #     return True
    
    # count = 0

    # for word_len in range(1, length + 1):
    #     # print(word_len)
    #     for start_idx in range(0, length - word_len + 1):
    #         if palindromic(s[start_idx:start_idx + word_len]):
    #             count += 1
    #     # print(count)

    # return count