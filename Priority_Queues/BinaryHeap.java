public class BinaryHeap<Key extends Comparable<Key>>{
    Key[] PQ;
    int N;
    
    public BinaryHeap(){
        N = 0;
        PQ = (Key[]) new Comparable[2]; 
    }

    public boolean isEmpty(){
        return N == 0;
    }
    
    public Key delMax(){
        Key ret = PQ[1];
        PQ[1] = PQ[N--];
        sink(1);
        return ret;
    }
    
    public void insert(Key x){
        if (N > (PQ.length - 1) * 3 / 4){
            resize(true);
        }
        
        if (N < (PQ.length - 1) / 4){
            resize(false);
        }
        PQ[++N] = x;
        swim(N);
    }

    public void sink(int k){
        int child;
        if (k*2 > N) return;
        else if(k*2 + 1 > N) return;
        if (less(PQ[k*2 + 1], PQ[k*2])) child = k*2;
        else child = k*2 + 1;
        
        if (less(PQ[child],PQ[k])) return;
        else{
            exch(PQ,child,k);
        }
        sink(child);
    }
    
    public void swim(int k){
        if (k/2 < 1) return;
        if (less(PQ[k/2],PQ[k])){
            exch(PQ,k,k/2);
        }
        else return;
        
        swim(k/2);
    }
    
    public void resize(boolean big){
        if (big){
            Key[] temp = (Key[]) new Comparable[PQ.length*2];
            for (int i = 0; i < PQ.length;i++){
                temp[i] = PQ[i];
            }
            PQ = temp;
        }
        else{
            Key[] temp = (Key[]) new Comparable[PQ.length/2];
            for (int i = 0; i < PQ.length;i++){
                temp[i] = PQ[i];
            }
            PQ = temp;
        }
    }
    
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) == -1;
    }
    
    public void exch(Key[] a, int c, int d){
        Key temp = a[c];
        a[c] = a[d];
        a[d] = temp;
    }
    
    public void printItems(){
        for (int i = 0; i < N+1; i++){
            System.out.println(PQ[i]);
        }
    }
}