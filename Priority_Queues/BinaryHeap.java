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
        Key ret = PQ[N];
        PQ[0] = PQ[N--];
        sink(0);
        return ret;
    }
    
    public void insert(Key x){
        if (N > PQ.length * 3 / 4){
            resize(true);
        }
        
        if (N < PQ.length / 4){
            resize(false);
        }
        PQ[++N] = x;
        swim(N);
    }

    public void sink(int N){
        int child;
        if (less(PQ[N*2 + 1], PQ[N*2])) child = N*2;
        else child = N*2 + 1;
        if (child > N) return; 
        if (less(PQ[child],PQ[N])) return;
        else{
            exch(PQ,child,N);
        }
        sink(child);
    }
    
    public void swim(int N){
        if (less(PQ[N/2],PQ[N])){
            exch(PQ,N,N/2);
        }
        else return;
        
        swim(N/2);
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
        for (int i = 0; i < N; i++){
            System.out.println(PQ[i]);
        }
    }
}