public class QuickSort{
    public void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    
    public void sort(Comparable[] a,int lo, int hi){
        if (hi <= lo){}
        else{
            int p = partition(a,lo,hi);
            System.out.println(p);
            sort(a,lo,p);
            sort(a,p+1,hi);
        }
    }
    
    public int partition(Comparable[] a,int lo, int hi){
        int j = lo + 1;
        int k = hi;
        
        while (true){
            while(less(a[lo],a[k])){
                if (k == hi) break;
                k--;
            }
            while(less(a[j],a[lo])){
                if (j == lo) break;
                j++;
            }
            
            if (j >= k) break;
            exch(a,j,k);
        }
        
        exch(a,lo,j);
        return k;
        
    }
    
    public void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) == -1;
    }
}