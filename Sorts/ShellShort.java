public class ShellSort{
    public Comparable[] sort(Comparable[] a){
        int b = 0;
        while (3*b + 1 < a.length){
            b += 1;
        }
        int N = 3*b + 1;
        
        while (N >= 1){
            for (int i = 0; i < a.length; i++){
                for (int j = i-N; j > 0; j-=N){
                    if (less(a[i],a[j])){
                        exch(a,i,j);
                    }
                }
            }
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