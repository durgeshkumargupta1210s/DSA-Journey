class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        String str="123456789";
        String l=low+"";
        String h=high+"";
        for(int i=l.length(); i<=h.length(); i++){
            for(int j=0; j<=9-i; j++){
                int num=Integer.parseInt(str.substring(j,j+i));
                if(num<=high && num>=low){
                    list.add(num);
                }
            }
        }
        return list;
        
    }
}