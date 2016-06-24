/**
 * Created by Artem on 24.06.16.
 */
class Sum extends Thread{
    int begin;
    int end;
    long result;
    int array[];
    volatile boolean flag=false;
    public Sum(int begin, int end,int[] array) {
        this.begin = begin;
        this.end = end;
        this.result = 0;
        this.array=array;
    }
    @Override
    public void run(){
        for(int i=begin;i<end;i++){
            result+=array[i];
        }
        flag=true;
    }

}
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] array= {1, 2, 3, 4, 5,6,7,8,9,10};
        long b=System.currentTimeMillis();
        System.out.println(b);
        Sum s1=new Sum(0,array.length/2,array);
        Sum s2=new Sum(array.length/2,array.length,array);
        s1.start();
        s2.start();

        s1.join();
        s2.join();
        long sum=s1.result+s2.result;
        System.out.println("s1.result "+s1.result);
        System.out.println("s2.result "+s2.result);
        System.out.println("sum "+sum);
        long e=System.currentTimeMillis();
        System.out.println(e);
        System.out.println(e-b);
    }
}
