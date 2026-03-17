class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Length of the array
        int n = nums.length;

        // List to store all unique quadruplets
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to apply two-pointer technique and handle duplicates
        Arrays.sort(nums);

        // If there are less than 4 elements, no quadruplet is possible
        if(n < 4){
            return result;
        }

        // First loop: fixing the first element of quadruplet
        for(int i = 0; i < n - 3; i++){

            // Skip duplicate values for i to avoid duplicate quadruplets
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // Second loop: fixing the second element of quadruplet
            for(int j = i + 1; j < n - 2; j++){

                // Skip duplicate values for j
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                // Two pointers for remaining two elements
                int left = j + 1;
                int right = n - 1;

                // Continue until the two pointers meet
                while(left < right){

                    // Use long to avoid integer overflow
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    // If sum equals target, we found a valid quadruplet
                    if(sum == target){

                        // Add the quadruplet to result list
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move both pointers
                        left++;
                        right--;

                        // Skip duplicate elements for left pointer
                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }

                        // Skip duplicate elements for right pointer
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }

                    // If sum is smaller than target, move left pointer to increase sum
                    else if(sum < target){
                        left++;
                    }

                    // If sum is greater than target, move right pointer to decrease sum
                    else{
                        right--;
                    }
                }
            }
        }

        // Return the list of all unique quadruplets
        return result;
    }
}