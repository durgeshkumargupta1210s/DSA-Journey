class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int evenSum = 0;

        // Step 1: Calculate initial even sum
        for(int num : nums){
            if(num % 2 == 0){
                evenSum += num;
            }
        }

        int[] ans = new int[queries.length];

        // Step 2: Process each query
        for(int i = 0; i < queries.length; i++){

            int val = queries[i][0];
            int idx = queries[i][1];

            // Step 3: Remove old value if it is even
            if(nums[idx] % 2 == 0){
                evenSum -= nums[idx];
            }

            // Step 4: Update value
            nums[idx] += val;

            // Step 5: Add new value if it is even
            if(nums[idx] % 2 == 0){
                evenSum += nums[idx];
            }

            // Step 6: Store result
            ans[i] = evenSum;
        }

        return ans;
    }
}
