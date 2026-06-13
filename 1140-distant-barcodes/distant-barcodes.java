class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map=new HashMap<>();
        int len=barcodes.length;
        for(int i=0; i<len; i++){
            map.put(barcodes[i],map.getOrDefault(barcodes[i],0)+1);
        }

        int maxfreq=0;
        int maxcode=0;

        for(int key : map.keySet()){
            if(map.get(key)>maxfreq){
                maxfreq=map.get(key);
                maxcode=key;
            }
        }

        int [] ans=new int[len];
        int idx=0;


        while(map.get(maxcode)>0){
          ans[idx]=maxcode;
          idx+=2;
          map.put(maxcode,map.get(maxcode)-1);
        }

        for (int key : map.keySet()) {
            while (map.get(key) > 0) {

                if (idx >= len) {
                    idx = 1; // move to odd indices
                }

                ans[idx] = key;
                idx += 2;

                map.put(key, map.get(key) - 1);
            }
        }

        return ans;


        
    }
}