class Solution {
    public double calculateTax(int[][] brackets, int income) {

        double tax = 0;
        int previous = 0;

        for (int i = 0; i < brackets.length; i++) {

            int upper = brackets[i][0];
            int percent = brackets[i][1];

            if (income <= upper) {
                tax += (income - previous) * percent / 100.0;
                break;
            }

            tax += (upper - previous) * percent / 100.0;

            previous = upper;
        }

        return tax;
    }
}