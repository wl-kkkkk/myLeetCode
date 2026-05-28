import java.util.*;
public class Solution89 {
    /*
    1. 1位格雷码有两个码字
    2. (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
    3. (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1
    4. n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
    */
    public List<Integer> grayCode(int n) {
        List<Integer> gray=new ArrayList<>();
        gray.add(0);
        for(int i=0;i<n;i++){
            int num=gray.size();
            //前2n个不用动
            //放后2n个`
            for(int j=num-1;j>=0;j--){
                //这里是1左移后 与 原来的数字进行或运算
                gray.add(gray.get(j) | 1<<i);
            }
        }
        return gray;
    }
}
