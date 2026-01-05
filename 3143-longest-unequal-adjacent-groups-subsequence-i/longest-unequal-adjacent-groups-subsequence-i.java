class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] group) {
        List<String> list=new ArrayList<>();

        list.add(words[0]);
        int lastgroup=group[0];

        for(int i=1; i<group.length; i++){
            if(group[i]!=lastgroup){
                list.add(words[i]);
                lastgroup=group[i];
            }
        }
        return list;
       
    }
}