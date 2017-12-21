package ctci;

/**
 * Created by sunil on 11/4/17.
 */
public class Sort {
    public static void main(String[] args){
        Sort obj = new Sort();
        int[] arr = new int[]{9,0,3,1,7,6,5,2,8,4,1};
        System.out.print("Input Array::\t");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

        obj.bubbleSort(arr);
        obj.selectionSort(arr);
        obj.mergeSort(arr);
        obj.quickSort(arr);

        System.out.print("\nBinarySearch::\t"+obj.binarySearch(arr, 2));
        System.out.print("\nBinarySearch_rec::\t"+obj.binarySearch_rec(arr, 2, 0, arr.length));
    }
    // BUBBLE SORT
    //Pair wise comparision and at the end the arr gets sorted, Run Time: n^2
    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=0; j<arr.length-1;j++)
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
        System.out.print("\n\nBubbleSort::\t");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    //SELECTION SORT
    //Select the smaller in each iteration and place it at the position, Run Time: n^2
    public void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(index>arr[j])
                    index=j;
            }
            int temp = arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }

        System.out.print("\nSelectionSort::\t");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

   // MERGE SORT   Run Time: nlog(n)  Space: n (auxiliary space, depends)
    void mergeSort(int[] arr){
        int[] helper = new int[arr.length];
        arr = new int[]{9,0,3,1,7,6,5,2,8,4,1};
        //mergeSort(arr, helper, 0, arr.length-1);

        System.out.print("\nMergeSort::\t\t");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public void mergeSort(int[] arr, int[] helper, int start, int end){
        if(start<end){
            int mid = start+(end-start)/2;
            mergeSort(arr, helper, start, mid);
            mergeSort(arr, helper, mid+1, end);
            merge(arr, helper, start, mid, end);
        }
    }
    public void merge(int[] arr, int[] helper, int start, int mid, int end){

        for(int i=start;i<=end;i++)
            helper[i]=arr[i];

        int h_left=start, h_right=mid+1, cur=start;
        while(h_left<=mid && h_right<=end){
            if(helper[h_left]<=helper[h_right]){
                arr[cur] = helper[h_left];
                h_left++;
            }else{
                arr[cur] = helper[h_right];
                h_right++;
            }
            cur++;
        }
        while(h_left<=mid){
            arr[cur++]=helper[h_left++];
        }
    }

   // end -- mergeSort

    //QUICK SORT:: Run Time: nlog(n), worst case; n^2 || Space: Log(N)
    void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);

        System.out.print("\nQuickSort::\t\t");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    void quickSort(int[] arr, int left, int right){
        int index = partition(arr, left, right);
        if(left<index-1)
            quickSort(arr, left, index-1);
        if(index<right)
            quickSort(arr, index, right);
    }

    int partition(int[] arr, int left, int right){
        int pivot = arr[(left+right)/2];
        while(left<=right){
            // Find element on left that should be on right
            while(arr[left]<pivot) left++;
            // Find element on right that should be on left
            while(arr[right]>pivot) right--;
            //Swap elements. Move left&right indices.
            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    // end -- QuickSort

    //Binary Search
    int binarySearch(int[] arr, int x){
        int start=0, end = arr.length-1, mid;

        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]>x)
                end=mid-1;
            else if(arr[mid]<x)
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }

    int binarySearch_rec(int[] arr, int x, int start, int end){
        if(start>end) return -1;

        int mid = (start+end)/2;
        if(arr[mid]<x)
            return binarySearch_rec(arr, x, mid+1, end);
        else if(arr[mid]>x)
            return binarySearch_rec(arr, x, start, mid-1);
        else
            return mid;
    }

}
