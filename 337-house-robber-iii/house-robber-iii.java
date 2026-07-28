class Solution {

    static int[][] dp;
    static HashMap<TreeNode,Integer> indexMap;
    static int count;


    public int rob(TreeNode root) {

        indexMap = new HashMap<>();
        count = 0;

        assignIndex(root);

        dp = new int[count][2];

        for(int i=0;i<count;i++){
            Arrays.fill(dp[i],-1);
        }

        return dfs(root,true);
    }


    public void assignIndex(TreeNode root){

        if(root==null)
            return;

        indexMap.put(root,count++);

        assignIndex(root.left);
        assignIndex(root.right);
    }


    public int dfs(TreeNode root, boolean flag){

        if(root==null)
            return 0;


        int index = indexMap.get(root);

        int state = flag ? 1 : 0;


        if(dp[index][state] != -1)
            return dp[index][state];


        int include = root.val
                + dfs(root.left,false)
                + dfs(root.right,false);


        int exclude = dfs(root.left,true)
                + dfs(root.right,true);


        if(flag){

            dp[index][state] = Math.max(include,exclude);

        }
        else{

            dp[index][state] = exclude;

        }


        return dp[index][state];
    }
}