class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> st;
        for(int i=0; i<nums.size(); i++){
            if(!st.insert(nums[i]).second){
                return true;
            }
        }
        return false;

        //st.insert(num).second == true → element was inserted (not a duplicate).
       // st.insert(num).second == false → element already exists (duplicate found).
        
        
    }
};