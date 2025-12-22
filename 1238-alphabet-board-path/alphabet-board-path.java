class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();

        int curRow = 0, curCol = 0; 

        for (char ch : target.toCharArray()) {
            int idx = ch - 'a';
            int targetRow = idx / 5;
            int targetCol = idx % 5;

            while (curCol > targetCol) {
                ans.append('L');
                curCol--;
            }

            while (curRow > targetRow) {
                ans.append('U');
                curRow--;
            }

            while (curCol < targetCol) {
                ans.append('R');
                curCol++;
            }

            while (curRow < targetRow) {
                ans.append('D');
                curRow++;
            }

            ans.append('!');
        }

        return ans.toString();
    }
}
