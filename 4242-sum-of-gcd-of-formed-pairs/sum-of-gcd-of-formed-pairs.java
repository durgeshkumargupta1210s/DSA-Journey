class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int []mx=new int[n];
        mx[0]=nums[0];
        for(int i=1; i<n; i++){
            int prefixmax=Math.max(mx[i-1],nums[i]);
            mx[i]=prefixmax;
        }

        int [] prefixgcd=new int[n];
        for(int i=0; i<n; i++){
            prefixgcd[i]=gcd(mx[i],nums[i]);
        }

        Arrays.sort(prefixgcd);
        long ans=0;
        int left=0;
        int right=n-1;

        while(left<right){
            ans+=gcd(prefixgcd[left],prefixgcd[right]);
            left++;
            right--;
        }
        return ans;


        
    }
    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}