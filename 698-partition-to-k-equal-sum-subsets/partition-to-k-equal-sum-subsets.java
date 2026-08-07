class Solution {

    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (int x : nums)
            sum += x;

        if (sum % k != 0)
            return false;

        target = sum / k;

        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        if (nums[0] > target)
            return false;

        boolean[] visited = new boolean[nums.length];

        return solve(nums, visited, 0, 0, k);
    }

    public boolean solve(int[] nums, boolean[] visited,
            int start, int currentSum, int k) {

        if (k == 1)
            return true;

        if (currentSum == target)
            return solve(nums, visited, 0, 0, k - 1);

        for (int i = start; i < nums.length; i++) {

            if (visited[i])
                continue;

            if (currentSum + nums[i] > target)
                continue;
            if (i > start && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            visited[i] = true;
            if (solve(nums, visited,
                    i + 1,
                    currentSum + nums[i],
                    k))
                return true;

            visited[i] = false;
            if (currentSum == 0)
                return false;

            if (currentSum + nums[i] == target)
                return false;
        }

        return false;
    }
}