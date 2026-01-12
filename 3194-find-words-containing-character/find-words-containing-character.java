class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> list=new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String str=words[i];
            if(str.contains(String.valueOf(x))){
                list.add(i);
            }
        }
        return list;
    }
}