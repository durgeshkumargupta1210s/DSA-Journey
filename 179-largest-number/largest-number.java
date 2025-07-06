class Solution {
    public String largestNumber(int[] nums) {

        
        // Convert the integers to strings
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        // Sort strings using a lambda expression for comparison
        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is '0', return '0'
        if (numsStr[0].equals("0")) {
            return "0";
        }

        // Join all strings to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String numStr : numsStr) {
            largestNumber.append(numStr);
        }

        return largestNumber.toString();
    }

 
        
    
}