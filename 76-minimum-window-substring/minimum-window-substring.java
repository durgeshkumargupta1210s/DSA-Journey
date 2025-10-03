class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch=t.charAt(i);
            map.put(ch,  map.getOrDefault(ch,0)+1);
        }

        int si=0;
        int sub_si=0;
        int ans=Integer.MAX_VALUE;
        int ei=0;
        int rc=t.length();
        while(ei<s.length()){
            char ch=s.charAt(ei);
            if(map.containsKey(ch)&&map.get(ch)>0)
            rc--;

            map.put(ch,map.getOrDefault(ch,0)-1);
            
           
            while(rc==0){
               char sc=s.charAt(si);
               map.put(sc,map.get(sc)+1);

               if(ans>ei-si+1){
                ans=ei-si+1;
                sub_si=si;
               }
               if(map.get(sc)>0){
                rc++;
               } 
               si++;
            }
            ei++;
        }
        return ans==Integer.MAX_VALUE?"":s.substring(sub_si,sub_si+ans);
    }
}