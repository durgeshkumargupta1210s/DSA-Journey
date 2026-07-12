class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {

        int zeroCount = 0;
        long long product = 1;

        // Product of all non-zero elements
        for (int x : nums) {
            if (x == 0)
                zeroCount++;
            else
                product *= x;
        }

        for (int i = 0; i < nums.size(); i++) {

            if (zeroCount > 1) {
                nums[i] = 0;
            }
            else if (zeroCount == 1) {

                if (nums[i] == 0)
                    nums[i] = product;
                else
                    nums[i] = 0;

            }
            else {

                nums[i] = product / nums[i];

            }
        }

        return nums;
    }
};