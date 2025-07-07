class Solution {
    public String intToRoman(int num) {
        int [] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] sym = {"M",  "CM","D", "CD","C", "XC","L", "XL","X","IX","V","IV","I"};
        StringBuilder result=new StringBuilder();

        while(num>0){
            for(int i=0; i<val.length; i++){
                if(val[i]<=num){
                    int times=num/val[i];
                    int rem=num%val[i];
                    result.append(sym[i].repeat(times));
                    num=rem;
                }
            }
        }
       return  result.toString();
        
    }
}