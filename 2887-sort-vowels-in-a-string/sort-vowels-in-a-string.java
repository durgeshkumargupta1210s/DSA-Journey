class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'A','E','I','O','U','a','e','i','o','u'
        ));

        List<Character> vowelList = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                vowelList.add(ch);
            }
        }
        
        Collections.sort(vowelList);
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                sb.append(vowelList.get(idx++));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
