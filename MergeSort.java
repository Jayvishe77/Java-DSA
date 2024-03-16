class MergeSort{    //TC O(nlogn)
    public static void conquer(int[] arr, int si, int mid, int ei){ //TC O(n)
        int merged[] = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;
        while(idx1 <= mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]) merged[x++] = arr[idx1++];
            else merged[x++] = arr[idx2++];
        }
        while (idx1<=mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2<=ei) {
            merged[x++] = arr[idx2++];
        }
        for(int i=0, j=si; i<merged.length; i++, j++){
            arr[j] = merged[i];
        }
    }
    public static void divide(int[] arr, int si, int ei){   //TC O(logn)
        if(si >= ei){
            return;
        }//mid 3
        int mid = si + (ei-si)/2;//si 3 ei 4
        divide(arr, si, mid);//return
        divide(arr, mid+1, ei); //return
        conquer(arr, si, mid, ei);//[5,2] 3 3 4
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        divide(arr, 0, n-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}