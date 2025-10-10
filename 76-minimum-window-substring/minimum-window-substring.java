class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        Map<Character, Integer> map=new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int si=0,  need=t.length(), ans=Integer.MAX_VALUE,sub_si=0;

        for(int ei=0; ei<s.length(); ei++){
           char ch=s.charAt(ei);

           if(map.containsKey(ch) && map.get(ch)>0){
              need--;   
           }
           map.put(ch,map.getOrDefault(ch,0)-1);

            while(need==0){
                char ch1=s.charAt(si);
                if(ans>ei-si+1){
                ans=ei-si+1;
                sub_si=si;
                }
                map.put(ch1,map.getOrDefault(ch1,0)+1);

                if(map.get(ch1)>0){
                    need++;
                }
                si++;
            }
           
        }
        return ans==Integer.MAX_VALUE?"":s.substring(sub_si,sub_si+ans);   
    }
}