class Solution {
    int count=0;
    public int countArrangement(int n) {  
        boolean[] visited=new boolean[n];
        int position=1;
        GeneratePermutation(n,position,visited);
        return count; 
    }
    
    public void GeneratePermutation(int n ,int position,boolean[] visited){
        if(position>n){
           count++;
            return;
        }
        
        for(int i=1; i<=n; i++){
            if(!visited[i-1] && (i%position==0 || position%i==0)){
                visited[i-1]=true;
                GeneratePermutation(n,position+1,visited);
                visited[i-1]=false;
            }
        }
    }
}