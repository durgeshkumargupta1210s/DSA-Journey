class Solution {
public:
    long long maxProduct(const vector<int>& nums) {
    long long a = 0, b = 0;
    for (int x : nums) {
        long long ax = llabs((long long)x);
        if (ax >= a) { b = a; a = ax; }
        else if (ax > b) { b = ax; }
    }
    return 100000LL * a * b;
}
};
