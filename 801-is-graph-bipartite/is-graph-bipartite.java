class Solution {
    List<List<Integer>> list;
    public boolean isBipartite(int[][] graph) {
        list=new ArrayList<>();
        int n=graph.length;

        for(int i=0; i<n; i++ ){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            int u=i;
            for(int j=0; j<graph[i].length; j++){
                int v=graph[i][j];
                list.get(u).add(v);
                list.get(v).add(u);

            }
        }

        
        int [] color=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=0; i<n; i++){
            if(color[i]==-1){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                color[i]=0;

                while(!q.isEmpty()){
                    int node=q.poll();

                    for(int nbrs : list.get(node)){
                         
                         if(color[nbrs]==color[node]){
                            return false;
                         }

                         if(color[nbrs]==-1){
                            color[nbrs]=1-color[node];
                            q.add(nbrs);
                         }
                    }
                }
            }
        }
        return true;
    }
}