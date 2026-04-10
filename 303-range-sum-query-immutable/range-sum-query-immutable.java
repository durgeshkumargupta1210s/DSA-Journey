class NumArray {

    // Array to store prefix sums
    // prefix[i] = sum of elements from index 0 to i
    int prefix[];

    public NumArray(int[] nums) {

        int n = nums.length;

        // Initialize prefix array with same size as input
        prefix = new int[n];

        // Base case:
        // First element of prefix is same as nums[0]
        prefix[0] = nums[0];

        // Build prefix sum array
        // Each element stores cumulative sum up to that index
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }
    
    // Function to return sum of elements from index 'left' to 'right' (inclusive)
    public int sumRange(int left, int right) {

        // If range starts from index 0,
        // directly return prefix[right]
        if(left == 0) return prefix[right];

        // Otherwise, subtract prefix sum before 'left'
        // Formula: sum(left → right) = prefix[right] - prefix[left - 1]
        return prefix[right] - prefix[left - 1];
    }
}