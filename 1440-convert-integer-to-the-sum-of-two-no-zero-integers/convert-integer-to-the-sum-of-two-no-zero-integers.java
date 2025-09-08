class Solution {
    public int[] getNoZeroIntegers(int n) {
        // List<Integer> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            int a=i;
            int b=n-i;

            String str1=a+"";
            String str2=b+"";
            if(!str1.contains("0") && !str2.contains("0") ){
                    return new int[] {a,b};
            }
        }
        return new int[] {0,0};

        
    }
}