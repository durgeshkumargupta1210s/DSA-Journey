class Solution {
    public int characterReplacement(String s, int k) {
        int si=0, ei=0, maxLen=0,maxCount=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(ei=0; ei<s.length(); ei++){
            char ch=s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1); // growing 

            maxCount=Math.max(maxCount,map.get(ch));

            while((ei-si+1)-maxCount>k){ // shrinking 
                char c=s.charAt(si);
                map.put(c,map.get(c)-1);

                if(map.get(c)==0){
                    map.remove(c);
                }
                si++;
            }

            maxLen=Math.max(maxLen,ei-si+1); // ans
        }

        return maxLen;

        
    }
}