class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            return list;
        }

        int start = nums[0];

        for (int i = 0; i < nums.length; i++) {

            // Check if range ends
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {

                if (start != nums[i]) {
                    list.add(start + "->" + nums[i]);
                } else {
                    list.add(String.valueOf(start));
                }

                // Start new range
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }

        return list;
    }
}