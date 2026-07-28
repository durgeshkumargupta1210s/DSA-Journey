class Solution {
    public String smallestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        StringBuilder left=new StringBuilder();
        String middle="";


        for(char ch='a' ; ch<='z'; ch++){
            if(!map.containsKey(ch)){
                continue;
            }
            int count=map.get(ch);

            for(int i=0; i<count/2; i++){
                left.append(ch);
            }

            if(count%2==1){
                middle = String.valueOf(ch);
            }
        }

        String right=left.reverse().toString();

        left.reverse();

        return left.toString() + middle + right;
        
    }
}