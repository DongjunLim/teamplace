/*
  나는 투포인트로 풀었음 매우느림
  다른 풀이법을보니 O(N)이 가능함 (맨 밑에 풀이)
/*

class Solution {
    public String longestCommonPrefix(String[] strs) {
        HashMap<String,Integer> map=new HashMap();
        int max=0;String maxS="";
        if(strs.length==1)return strs[0];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=strs[i].length();j++){
                String temps=strs[i].substring(0,j);
                if(!map.containsKey(temps)){
                    map.put(temps,1);
                }else{
                    map.put(temps,map.get(temps)+1);
                }
            }
        }
        Set<String> set=map.keySet();
        for(String s:set){
            int temp=map.get(s);
            if(max<=temp&&temp!=1){
                max=temp;
                if(s.length()>maxS.length())
                maxS=s;
            }
        }
        return maxS;
    }
}

//    public int longestMountain(int[] A) {
//        int increase = 0, decrease = 0, max = 0;
//        for (int i = 1; i < A.length; i++) {
//            if (A[i] > A[i - 1]) {
//                // first increasing point, initialize increase
//                if (i - 2 < 0 || i - 2 >= 0 && A[i - 1] <= A[i - 2]) increase = 1;
//                // update increase, make sure decrease is 0
//                increase++;
//                decrease = 0;
//            } else if (A[i] < A[i - 1]) {
//                decrease++;
//                if (increase > 0) max = Math.max(max, increase + decrease);
//            } else {
//                // A[i] == A[i - 1]
//                increase = 0;
//                decrease = 0;
//            }
//        }
//        return max;
//    }
