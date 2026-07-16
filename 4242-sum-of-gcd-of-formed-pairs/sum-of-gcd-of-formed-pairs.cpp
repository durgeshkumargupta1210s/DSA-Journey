class Solution {
public:
    long long gcdSum(vector<int>& nums) {
        int n=nums.size();
        vector<int> mx(n);
        mx[0]=nums[0];
        for(int i=1; i<n; i++){
            mx[i]=max(mx[i-1],nums[i]);
        }

        vector<int>prefixgcd(n);
        for(int i=0; i<n; i++){
            prefixgcd[i]=gcd(mx[i],nums[i]);
        }

        sort(prefixgcd.begin(),prefixgcd.end());

        int left=0;
        int right=n-1;
        long long ans=0;

        while(left<right){
            ans+=gcd(prefixgcd[left],prefixgcd[right]);
            left++;
            right--;
        }
        return ans;
        
    }

    int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

    
};