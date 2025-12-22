class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = s.length();
        int[] match = new int[n];
        for (int i = 0; i < n; i++) {
            match[i] = -1;
        }
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            String src = sources[i];
            if (idx + src.length() <= n &&
                s.substring(idx, idx + src.length()).equals(src)) {
                match[idx] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (match[i] != -1) {
                int k = match[i];
                sb.append(targets[k]);
                i += sources[k].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
