import java.awt.*;

/**
 * Created by liubin on 2016/11/13.
 */


//最大堆，堆顶元素最大，每个子堆都满足对应的有序性，即子堆的堆顶元素也是子堆最大的元素
public class MaxHeap {

    public int[] array;
    public int length;

    //无参数初始化最大堆
    public MaxHeap(){
        length=0;
        array=new int[10];
    }

    //有参数初始化最大堆
    public MaxHeap(int[] input)
    {
        if(input==null||input.length==0){
            length=0;
        }else{
            length=input.length;
            array=new int[2*length];
            for(int i=0;i<input.length;i++)
            {
                array[i]=input[i];
            }

            for(int i=length/2-1;i>=0;i--){
                adjustMaxHeap(array,i,length-1);
            }

            DisplayHeap();
        }
    }

    //调整最大堆,从上向下过滤,将大于该位置的元素上移
    public void adjustMaxHeap(int[] array,int pos,int length){
        int temp=0,child=0;
        for(temp=array[pos];child*2+1<=length;pos=child){
            child=2*pos+1;
            if(child<length&&array[child]<array[child+1]){
                child++;
            }
            if(array[child]>temp){
                array[pos]=array[child];
            }else{
                break;
            }
        }
        array[pos]=temp;
    }

    //出堆，这样形成一个有序数组
    public int deHeap(){
        int val=-1;
        if(length!=0){
            val=array[0];
            array[0]=array[length-1];
            length--;
            adjustMaxHeap(array,0,length-1);
        }
        return val;
    }

    //插入数据，应将数据置于最末尾，然后向上过滤
    public void insert(int val){
        if(length==array.length){
            int[] tmp=new int[2*length];
            for(int i=0;i<length;i++){
                tmp[i]=array[i];
            }
            array=tmp;
        }
        array[length++]=val;
        if(length!=1){
            SiftUp(length-1);
        }
    }

    //向上冒泡
    public void SiftUp(int pos){
        int tmp=array[pos];
        int i=(pos-1)/2;
        while(i>0&&array[i]<tmp){
            array[pos]=array[i];
            pos=i;
            i=(pos-1)/2;
        }
        array[i]=tmp;
    }

    //将堆中的数据打印显示出来
    public void DisplayHeap(){
        if(length!=0){
            System.out.println("length:"+length);
            for(int i=0;i<length;i++)
            {
                System.out.print(array[i]+"\t");
            }
            System.out.println();
        }
    }

    //判断堆是否为空
    public boolean empty(){
        return length==0?true:false;
    }
}
