class Solution {
    public String largestMerge(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder sb=new StringBuilder();
        while(i<word1.length() && j<word2.length()){
            char ch1=word1.charAt(i);
            char ch2=word2.charAt(j);

            if(ch1>ch2){
                sb.append(ch1);
                i++;
            }
            else if(ch1<ch2){
                sb.append(ch2);
                j++;
            }
            else{
              String str1=word1.substring(i);
              String str2=word2.substring(j);
              if(str1.compareTo(str2)>=0){
                sb.append(ch1);
                i++;
              }
              else{
                sb.append(ch2);
                j++;
              }
            }
        }

        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();

      
        
    }
}