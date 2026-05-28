import java.util.*;
public class Chooseme {
    public static void ChooseMed(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        med[] meds=new med[n];
        //存药
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            meds[i]=new med(a,b);
        }
        //按疼痛值排序
        Arrays.sort(meds,new Comparator<med>() {
            @Override
            public int compare(med o1, med o2) {
                if(o1.a!=o2.a) return o1.a-o2.a;
                return o2.b-o1.b;
            }
        });
        //预处理
        int[] premax=new int[n];
        premax[0]=meds[0].b;
        for(int i=1;i<n;i++){
            premax[i]=Math.max(premax[i-1],meds[i].b);
        }
        //开始接客人
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int temp=sc.nextInt();
            //查找可以忍受的疼痛值
            int place=finda(meds,temp);
            if(place==-1) System.out.println(-1);
            else System.out.println(premax[place]);

        }
    }
    public static int finda(med[] meds,int temp){
        int mid;
        int l=-1;
        int r=meds.length;
        while(l+1!=r){
            mid=(l+r)/2;
            if(meds[mid].a>temp) r=mid;
            else if(meds[mid].a<temp) l=mid;
            else return mid;
        }
        return l;
    }
}
class med{
    int a;
    int b;
    public med(int a,int b){
        this.a=a;
        this.b=b;
    }
}
