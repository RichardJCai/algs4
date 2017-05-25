public class MergeSort{
    public void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        int low = 0;
        int hi = a.length - 1;
        sort(a,aux,low,hi);
    }
    
    public void sort(Comparable[] a, Comparable[] aux, int low, int hi){
//        for (int i = low; i <= hi;i++){
//            System.out.print(a[i]);
//        }
//        System.out.print("\n");
//        
        if ((hi-low) <= 0){}
        else{
            sort(a,aux,low,(low+hi)/2);
            sort(a,aux,(low+hi)/2 + 1, hi);
            merge(a,aux,low,(low+hi)/2,hi);
        }
        

    }
    
    public void merge(Comparable[] a, Comparable[] aux, int low, int mid, int hi){
        int l = low; //Left pivot
        int k = mid+1; //Right pivot
        
        for (int i = low; i <= hi; i++){
            aux[i] = a[i];
        }
        
        for (int j = low; j <= hi; j++){
            if (l > mid){
                a[j] = aux[k++];
            }
            else if(k > hi){
                a[j] = aux[l++];
            }
            else if(less(aux[l],aux[k])){
                a[j] = aux[l++];
            }
            else{
                a[j] = aux[k++];
            }
        }
    }
    
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) == -1;
    }
}