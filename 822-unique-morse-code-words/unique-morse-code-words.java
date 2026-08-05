class Solution {
    static String [] arr={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set=new HashSet<>();
        for(String str : words){
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<str.length(); i++){
                int num=str.charAt(i)-'a';
               sb.append(arr[num]);
            }
            set.add(sb.toString());
        }

        return set.size();
        
    }
}