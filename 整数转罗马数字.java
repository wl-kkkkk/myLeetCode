//每个位数其实是固定的，故可以直接给出答案，时间复杂度O(1)
class Solution {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public String intToRoman(int num) {
        StringBuffer res=new StringBuffer();
        res.append(thousands[num/1000]);
        res.append(hundreds[num%1000/100]);
        res.append(tens[num%100/10]);
        res.append(ones[num%10]); 
        return res.toString();
    }
}
//暴力算法，模拟人脑过程
//第二种方法，复杂
class Solution {
    public String intToRoman(int num) {
        String res="";
        while(num>=1000){
            num-=1000;
            res+="M";
        }
        if(num>=100){
            if(num/100==4||num/100==9){
                if(num/100==4)  res+="CD";
                if(num/100==9)  res+="CM";
                num=num%100;
            }
            if(num>=500){
                res+="D";
                num-=500;
            }
            while(num>=100){
                num-=100;
                res+="C";
            }
        }
        if(num>=10){
            if(num/10==4||num/10==9){
                if(num/10==4)  res+="XL";
                if(num/10==9)  res+="XC";
                num=num%10;
            }
            if(num>=50){
                res+="L";
                num-=50;
            }
            while(num>=10){
                num-=10;
                res+="X";
            }
        }
        if(num%10==4){
            res+="IV";
            num-=4;
        } 
        if(num%10==9){
            res+="IX";
            num-=9;
        } 
        if(num>=5){
            res+="V";
            num-=5;
        }
        while(num>0){
            res+="I";
            num-=1;
        }
        return res;
    }
}
