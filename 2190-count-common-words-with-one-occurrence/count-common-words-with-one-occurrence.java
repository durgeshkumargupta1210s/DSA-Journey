class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer>map=new HashMap<>();
        HashMap<String,Integer>map1=new HashMap<>();
        int count=0;
        for(int i=0;i<words1.length;i++)
        {
           
            if(map.containsKey(words1[i]))
            {
                int freq=map.get(words1[i]);
                map.put(words1[i],freq+1);
            }
            else
            {
                map.put(words1[i],1);
            }
        }
        for(int j=0;j<words2.length;j++)
        {
            if(map1.containsKey(words2[j]))
            {
                int freq=map1.get(words2[j]);
                map1.put(words2[j],freq+1);
            }
            else
            {
                map1.put(words2[j],1);
            }
        }

        for(String ele:map.keySet())
        {
            if(map.get(ele)==1 && map1.getOrDefault(ele,0)==1)count++;
        }
        return count;

    }
}