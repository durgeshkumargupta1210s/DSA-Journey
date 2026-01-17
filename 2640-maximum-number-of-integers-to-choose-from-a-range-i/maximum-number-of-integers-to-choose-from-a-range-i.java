class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        Set<Integer> set = new HashSet<>();
        for (int ele : banned) {
            set.add(ele);
        }

        int sum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {

                if (sum + i > maxSum) {
                    break;
                }

                sum += i;
                count++;
            }
        }

        return count;
    }
}
