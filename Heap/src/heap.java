import java.util.LinkedList;

/**
 * Created by liubin on 2016/11/7.
 */
public class heap {

    //数组最大的K个数，应用最小堆算法，堆顶元素最小
    public static LinkedList<Integer> maxTopK(int[] array,int k){
        if(array==null||array.length==0||array.length<=k)
            return null;

        LinkedList<Integer> result=new LinkedList<Integer>();

        //从已有数组构建最小堆
        for(int len=k/2-1;len>=0;len--){
            adjustMinHeap(array,len,k-1);
        }

        for(int i=k;i<array.length;i++){
            int val=array[i];
            if(val>array[0]){
                array[i]=array[0];
                array[0]=val;
                adjustMinHeap(array,0,k-1);
            }
        }
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }

        return result;
    }

    //调整最小堆,从上向下过滤
    public static void adjustMinHeap(int[] array,int pos,int length){
        int temp=0,child=0;
        for(temp=array[pos];child*2+1<=length;pos=child){
            child=2*pos+1;
            if(child<length&&array[child]>array[child+1]){
                child++;
            }
            if(array[child]<temp){
                array[pos]=array[child];
            }else{
                break;
            }
        }
        array[pos]=temp;
    }

    //只有将最小堆内的元素出堆，才能实现排序，删除堆顶元素时，需要对元素进行
    public static void deMinHeap(int[] array,int length){

    }

    public static void main(String[] args)
    {
        int[] array={10,20,30,40,16,32,23,92,20,18,23,12,13};
        int k=10;
        maxTopK(array,k);
    }
}
