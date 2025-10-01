class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st=new Stack<>();

        int area=0;
        int len=arr.length;

        for(int i=0; i<=arr.length; i++){

            int val=(i==len)?0 :arr[i];

            while(!st.isEmpty() && val<arr[st.peek()]){
                int nsr=i;
                int tbs=st.pop();
                int nsl=st.isEmpty()?-1:st.peek();

                int width=nsr-nsl-1;

                area=Math.max(width*arr[tbs], area);
            }
            st.push(i);

        }
        return area ;
        
    }
}