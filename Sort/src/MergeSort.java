/**
 * Created by liubin on 2016/11/7.
 */
public class MergeSort {

    //合并排序结果,针对单个数组进行合并，同时，可以传入一个临时数组参数，避免每次创建新的数组
    public void Merge(int[] a,int start,int mid,int end){
        int i=start,j=mid+1;
        int k=0;
        int[] b=new int[end-start+1];

        while(i<=mid&&j<=end){
            if(a[i]<=a[j]){
                b[k++]=a[i++];
            }else{
                b[k++]=a[j++];
            }
        }

        while(i<=mid){
            b[k++]=a[i++];
        }

        while(j<=end){
            b[k++]=a[j++];
        }

        //排序好的结果复制到原始数组中
        for(i=0;i<b.length;i++) {
            a[start + i] = b[i];
        }
    }

    //进行数据排序
    public void Sort(int[] a,int start,int end){
        if(start<end){
            int mid=start+(end-start)/2;
            Sort(a,start,mid);
            Sort(a,mid+1,end);
            Merge(a,start,mid,end);
        }
    }

    public void mergeSort(int[] a){
        if(a==null||a.length==0) {
            System.out.println("Not a valid array!");
            return;
        }

        Sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }

    //测试用例
    public static void main(String args[]){
        int[] a1=null;
        int[] a2={};
        int[] a3={1};
        int[] a4={2,3,1,9,20,6,9,7,63,2,12,20,20,14,15};
        MergeSort ms=new MergeSort();
        ms.mergeSort(a1);
        ms.mergeSort(a2);
        ms.mergeSort(a3);
        ms.mergeSort(a4);
    }
}
