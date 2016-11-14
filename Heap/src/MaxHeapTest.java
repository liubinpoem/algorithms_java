import java.util.Random;

/**
 * Created by liubin on 2016/11/13.
 */

//this class is
public class MaxHeapTest {

    public static void main(String args[]){
        Random rd=new Random();
        int numbers=30;
        int[] data=new int[numbers];

        for(int i=0;i<numbers;i++){
            data[i]=rd.nextInt(1000);
            System.out.print(data[i]+"\t");
        }
        System.out.println();

        MaxHeap mh=new MaxHeap(data);
        mh.insert(1000);
        mh.DisplayHeap();
        System.out.println();
        while(!mh.empty()){
            int val=mh.deHeap();
            System.out.print(val+"\t");
        }
        System.out.println();
    }
}
