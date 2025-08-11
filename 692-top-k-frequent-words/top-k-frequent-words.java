class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        return top_k_freq_words(words,k);
    }
    private static List<String> top_k_freq_words(String[] words, int k) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm=new HashMap<>();
		for(int i=0; i<words.length; i++) {
			hm.put(words[i], hm.getOrDefault(words[i],0)+1);
		}
	    List<Map.Entry<String, Integer>> list=new ArrayList<>(hm.entrySet());
	    Collections.sort(list,(obj1,obj2)-> {
//	    	
	    	int freq=obj2.getValue().compareTo(obj1.getValue());
	    	if(freq==0) {
//	    		if frequency is 0 then compare the key lexigraphically 
//	    		frequency 0 means two words have same frequency
	    		return obj1.getKey().compareTo(obj2.getKey());
	    	}
	    	return freq;		
	    });
	    String  [] arr=new String[k];
	    for(int i=0; i<k; i++) {
	    	arr[i]=list.get(i).getKey();
	    }
        // Arrays.sort(arr);
		return Arrays.asList(arr);
	}
}