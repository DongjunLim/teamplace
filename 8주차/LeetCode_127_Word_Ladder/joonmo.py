# 단순한 bfs로 하니까 당연히 타임오바
# wordList에서 파생가능한 단어 조합을 dict에 모두 저장한 뒤에 
# bfs를 실행할때 dict에서 필요한 것만 가져오는 식의 풀이 필요

from collections import deque, defaultdict

# 한글자 외에 일치하는지 확인
def check(word1, word2):
    cnt = 0
    N = len(word1)
    for idx in range(N):
        if word1[idx] == word2[idx]:
            cnt += 1
    if cnt == N-1:
        return True
    else:
        return False


def bfs(beginWord, endWord, wordList):

    L = len(beginWord)
    # defaultdict 로 wordList로 부터 가능한 단어 조합 모두 저장
    all_combo_dict = defaultdict(list)
    for word in wordList:
        for i in range(L):
            all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

    q = deque()
    q.append((beginWord, 1))
    visited = [beginWord]

    while q:
        curr_word, curr_seq_len = q.popleft()
        for i in range(L):
            intermediate_word = curr_word[:i] + "*" + curr_word[i+1:]


            for tmp_word in all_combo_dict[intermediate_word]:
                # 중복확인
                if tmp_word in visited:
                    continue
                else:
                    if tmp_word == endWord:
                        return curr_seq_len + 1
                    else:
                        q.append((tmp_word, curr_seq_len + 1))
                        visited.append(tmp_word)
    return 0 

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
    
        # 답이 wordList에 없을때
        if endWord not in wordList:
            return 0 
        
        else:
            return bfs(beginWord, endWord, wordList)
            