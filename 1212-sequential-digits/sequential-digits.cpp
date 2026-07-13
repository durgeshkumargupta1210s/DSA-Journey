class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int> v;

        // Base string containing sequential digits
        string str = "123456789";

        // Get the number of digits in low and high
        string l = to_string(low);
        string h = to_string(high);

        // Generate numbers of every possible length
        for (int i = l.length(); i <= h.length(); i++) {

            // Slide a window of length i
            for (int j = 0; j <= 9 - i; j++) {

                // Extract i consecutive digits
                int num = stoi(str.substr(j, i));

                // Check if it lies in the required range
                if (num >= low && num <= high) {
                    v.push_back(num);
                }
            }
        }

        return v;
    }
};