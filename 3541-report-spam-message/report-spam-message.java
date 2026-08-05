class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set=new HashSet<>();
        for(String s : bannedWords){
            set.add(s);
        }
        int count=0;
        for(String s : message){
            if(set.contains(s)){
                count++;
            }
        }

        if(count>=2){
            return true;
        }
        return false;

        
    }
}