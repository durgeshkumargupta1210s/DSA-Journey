class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int ans=0;
        int si=0;

        for(int ei=0; ei<s.length(); ei++){
            char ch=s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>1){
                char startChar = s.charAt(si);
                map.put(startChar,map.get(startChar)-1);
                if(map.get(startChar)==0){
                    map.remove(startChar);
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);

        }
        return ans;
        
    }
}