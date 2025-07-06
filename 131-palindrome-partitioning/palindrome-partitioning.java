class Solution {
    public List<List<String>> partition(String s) {
        List<String>ll=new ArrayList<>();
		List<List<String>> ans=new ArrayList<>();
		partitions(s,ll,ans);
		return ans;
        
    }
    private static void partitions(String ques,List<String> ll,List<List<String>> ans) {
		// TODO Auto-generated method stub
		if(ques.length()==0) {
			ans.add(new ArrayList(ll));
			return;
		}
		for(int i=1; i<=ques.length(); i++) {
			String s=ques.substring(0,i);
			if(ispalindrom(s)) {
				ll.add(s);
				partitions(ques.substring(i),ll,ans);
				ll.remove(ll.size()-1);
			}
			
		}
		
	}
	private static boolean ispalindrom(String s) {
		// TODO Auto-generated method stub
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}