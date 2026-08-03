import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        printPath(s, set, 0, new ArrayList<>());

        return ans;
    }

    public void printPath(String s, HashSet<String> set,
                          int idx, List<String> path) {

        
        if (idx == s.length()) {
            ans.add(String.join(" ", path));
            return;
        }

        
        for (int i = idx + 1; i <= s.length(); i++) {

            String word = s.substring(idx, i);

           
            if (set.contains(word)) {

                
                path.add(word);

                
                printPath(s, set, i, path);

             
                path.remove(path.size() - 1);
            }
        }
    }
}