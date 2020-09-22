import java.util.*;
/*
BFS

beginWord에서 endWord까지 최단거리
단, 한번에 한개의 글자만 바꿀 수 있음
set을 이용하여 중복 단어 검사를 방지하였음

가장 먼저 현 단어를 큐에 넣는다.
현재 단어를 기준으로 이동 할 수 있는 단어를 찾아(findNextWord) 큐에 넣는다.
이때, 또 다시 방문할 가능성이 있으므로 set에서 제거하여 중복 방문을 방지한다.

Time Complexity: O(V+E)
Space Complexity: O(V+E)

 */
public class Leetcode127_Word_Ladder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int answer = 0;
        Set<String> candidate = new HashSet<>();
        candidate.addAll(wordList);
        if (!candidate.contains(endWord)) return 0;

        Queue<String> que = new LinkedList<>();
        candidate.remove(beginWord);
        que.offer(beginWord);

        while (!que.isEmpty()) {
            int size = que.size();
            answer++;
            while (size-- > 0) {
                String currentWord = que.poll();

                if (currentWord.equals(endWord)) {
                    return answer;
                }
                List<String> nextWordList = findNextWord(currentWord, candidate);
                for (String nextWord : nextWordList) {
                    candidate.remove(nextWord);
                    que.offer(nextWord);
                }
            }
        }
        return 0;
    }


    private static List<String> findNextWord(String currWord, Set<String> setList) {
        List<String> nextWordList = new ArrayList<>();

        for (String word : setList) {
            int differ = 0;
            for (int i = 0; i < word.length(); i++) {
                if (currWord.charAt(i) != word.charAt(i)) differ++;
            }
            if (differ == 1) {
                nextWordList.add(word);
            }
        }
        return nextWordList;
    }


    public static void main(String[] args) {
        String beginWord = "cet";
        String endWord = "ism";
        String[] wordList = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now",
                "boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay",
                "col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis",
                "ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh",
                "sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova",
                "wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob",
                "for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot",
                "tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag",
                "hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw",
                "his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon",
                "dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani",
                "and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus",
                "oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt",
                "poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava",
                "rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let",
                "see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham",
                "sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who",
                "bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit",
                "fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado",
                "sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm",
                "nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem",
                "joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc",
                "moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup",
                "jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban",
                "flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun",
                "fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him",
                "all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk",
                "gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo",
                "tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz",
                "ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy",
                "foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow",
                "got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
/*
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

 */
        int result = ladderLength(beginWord, endWord, Arrays.asList(wordList));
        System.out.print(result);
    }
}
