class Solution {
    public List<String> printVertically(String s) {

        String[] arr = s.split(" ");

        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            len = Math.max(len, arr[i].length());
        }

        char[][] grid = new char[arr.length][len];

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                grid[i][j] = ch;
            }
        }

        List<String> result = new ArrayList<>();

        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] != '\0') {
                    sb.append(grid[i][j]);
                } else {
                    sb.append(" ");
                }
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            result.add(sb.toString());
        }

        return result;
    }
}