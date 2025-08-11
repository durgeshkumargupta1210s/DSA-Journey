class Solution {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        
        for (String op : ops) {
            if (op.equals("+")) {
                
                int size = scores.size();
                int newScore = scores.get(size - 1) + scores.get(size - 2);
                scores.add(newScore);
            } else if (op.equals("D")) {

                int lastScore = scores.get(scores.size() - 1);
                scores.add(lastScore * 2);
            } else if (op.equals("C")) {

                scores.remove(scores.size() - 1);
            } else {
                
                scores.add(Integer.parseInt(op));
            }
        }
    
        int result = 0;
        for (int score : scores) {
            result += score;
        }
        
        return result;
    }
}