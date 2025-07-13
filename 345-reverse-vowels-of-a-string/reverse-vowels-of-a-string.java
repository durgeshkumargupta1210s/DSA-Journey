class Solution {
    public String reverseVowels(String s) {
      return reverse_vowels(s);  
    }
    private static String reverse_vowels(String s) {
		// TODO Auto-generated method stub
		char [] temp=s.toCharArray();
		HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left=0;
        int right=temp.length-1;
        while(left<right) {
        	while (left < right && !vowels.contains(temp[left])) {
                left++;
            }
        	while (left < right && !vowels.contains(temp[right])) {
                right--;
            }
        	
        	char tem=temp[left];
			temp[left]=temp[right];
			temp[right]=tem;
			left++;
			right--;


        }
        return new String(temp);
		
	}
}