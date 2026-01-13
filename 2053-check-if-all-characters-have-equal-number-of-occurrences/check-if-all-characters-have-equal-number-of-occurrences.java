class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int prev=map.get(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            char ch=s.charAt(i);
            if(map.get(ch)!=prev){
                return false;
            }
        }
        return true;


        
    }
}