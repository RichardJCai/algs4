public class SelectionSort{
    public Comparable[] sort(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            int min = i;
            for (int j = i; j < a.length;j++){
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            
            exch(a,i,min);
        }
        return a;
    }
    
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) == -1;
    }
    
    public static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}