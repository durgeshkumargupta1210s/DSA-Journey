class Solution {
    public int beautifulSubstrings(String s, int k) {
        int count=0;
        for(int i=0; i<s.length(); i++){
            int vowel=0;
            int cons=0;

            for(int j=i; j<s.length(); j++){
                char ch=s.charAt(j);

                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowel++;
                }
                else{
                    cons++;
                }

                if((vowel==cons) && (vowel*cons)%k==0){
                    count++;
                }
            }

        }
        return count;
        
    }
}