class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Edge case: if the array is null or empty, there is no common prefix
        if(strs == null || strs.length == 0){
            return "";
        }

        // Assume the first string is the longest common prefix initially
        String assume = strs[0];

        // Compare this prefix with every other string in the array
        for(int i = 1; i < strs.length; i++){

            // If the current string does not start with the assumed prefix,
            // keep reducing the prefix length from the end
            while(!strs[i].startsWith(assume)){

                // Remove the last character from the assumed prefix
                assume = assume.substring(0, assume.length() - 1);

                // If the prefix becomes empty, no common prefix exists
                if(assume.isEmpty()){
                    return "";
                }
            }
        }

        // After checking all strings, return the longest common prefix
        return assume;
    }
}