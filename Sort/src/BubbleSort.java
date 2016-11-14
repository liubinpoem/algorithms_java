/**
 * Created by liubin on 2016/11/7.
 */
public class BubbleSort {

    //冒泡排序的思想，是每次把某个位置应放置的元素从该位置后面的数组中找出来，放置在该位置
    public void Sort(int[] array){
        for(int i=0;i<array.length-1;i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public void bubbleSort(int[] array){
        if(array!=null&&array.length>=1) {
            Sort(array);
            for (int k = 0; k < array.length; k++)
                System.out.print(array[k]+"\t");
            System.out.println();
        }else{
            System.out.println("Not a valid array!");
        }
    }

    //案例测试
    public static void main(String[] args){
        int[] a1=null;
        int[] a2={};
        int[] a3={1};
        int[] a4={2,3,1,9,20,6,9,7,63,2,12,20,20,14,15};

        BubbleSort bs=new BubbleSort();
        bs.bubbleSort(a1);
        bs.bubbleSort(a2);
        bs.bubbleSort(a3);
        bs.bubbleSort(a4);
    }
}
