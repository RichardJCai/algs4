public class ShellSort{
    public Comparable[] sort(Comparable[] a){
        int H = 1;
        while (H < a.length){
            H = 3*H+1;
        }
        H = H/3;
        
        while (H >= 1){
            System.out.println(H);
            for (int i = H; i < a.length; i++){
                for (int j = i; j > 0; j-=H){
                    if (less(a[j],a[j-H])){
                        System.out.println(a[j] +"and" + a[j-H]);
                        exch(a,j,j-H);
                    }
                }
            }
        H = H/3;
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