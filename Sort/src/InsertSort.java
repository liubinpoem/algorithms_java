/**
 * Created by liubin on 2016/11/7.
 */
public class InsertSort {

    //插入排序的核心思想为每次将一个数据插入到前面已经排序好的数据
    public void Sort(int[] array){
        int i,j,k;
        for(i=1;i<array.length;i++){
            for(j=i-1;j>=0;j--){
                //找到一个合适的位置
                if(array[j]<array[i])
                    break;
            }

            //将比array[i]大的数据后移,空出j+1的位置
            int tmp=array[i];
            for(k=i;k>j+1;k--){
                array[k]=array[k-1];
            }

            //将该数据放入j+1的位置
            array[j+1]=tmp;
        }
    }

    //包裹函数
    public void insertSort(int[] array){
        if(array!=null){
            if(array.length>=2) {
                Sort(array);
            }
            for (int k = 0; k < array.length; k++)
                System.out.print(array[k]+"\t");
            System.out.println();
        }else{
            if(array==null||array.length==0)
                System.out.println("Not a valid array!");
        }
    }

    //测试用例
    public static void main(String args[]){
        int[] a1=null;
        int[] a2={};
        int[] a3={1};
        int[] a4={9,10,20,30,15,8,1,7,8,10,100,99,70,29,30};
        InsertSort is=new InsertSort();
        is.insertSort(a1);
        is.insertSort(a2);
        is.insertSort(a3);
        is.insertSort(a4);
    }
}
