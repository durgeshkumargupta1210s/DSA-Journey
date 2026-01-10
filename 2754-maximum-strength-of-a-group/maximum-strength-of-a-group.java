import java.util.*;

class Solution {
    public long maxStrength(int[] nums) {

        long product = 1;
        int positiveCount = 0;
        int zeroCount = 0;

        // Store negative numbers
        List<Integer> negatives = new ArrayList<>();

        // Separate numbers
        for (int num : nums) {
            if (num > 0) {
                product *= num;
                positiveCount++;
            } else if (num < 0) {
                negatives.add(num);
            } else {
                zeroCount++;
            }
        }

        // Sort negatives by absolute value (ascending)
        Collections.sort(negatives, (a, b) -> Math.abs(a) - Math.abs(b));

        // If odd count of negatives, remove the smallest absolute value
        if (negatives.size() % 2 != 0) {
            negatives.remove(0);
        }

        // Multiply remaining negatives
        for (int num : negatives) {
            product *= num;
        }

        // If no number was selected
        if (positiveCount == 0 && negatives.isEmpty()) {
            // If zeros exist, max strength is 0
            if (zeroCount > 0) return 0;

            // Otherwise return the maximum (least negative) element
            long max = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        return product;
    }
}
