/**
 * Created by liubin on 2016/11/7.
 */
public class QuickSort {

    public QuickSort(int[] array){
        if(array!=null&&array.length!=0) {
            Sort(array, 0, array.length-1);
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+"\t");
            }
        }
    }

    //划分函数，将数组划分为两个部分
    public int Partition(int[] array,int start,int end){
        //设置标准元素
        int standard=array[start];

        while(start<end){
            while(start<end&&array[end]>standard){
                end--;
            }
            //将小于standard值的数据放入数组前部
            array[start]=array[end];
            while(start<end&&array[start]<=standard){
                start++;
            }
            //将大于standard数值的数放入数组后部
            array[end]=array[start];
        }
        array[start]=standard;
        return start;
    }

    //排序
    public void Sort(int[] array,int start,int end){
        if(start<end){
            int mid=Partition(array,start,end);
            Sort(array,start,mid-1);
            Sort(array,mid+1,end);
        }
    }

    //测试用例
    public static void main(String args[]){
        int[] a={9,10,20,30,15,8,1,7,8,10};
        QuickSort qs=new QuickSort(a);
    }
}
