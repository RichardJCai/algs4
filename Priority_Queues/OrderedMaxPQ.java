public class OrderedMaxPQ<Key extends Comparable<Key>>{
    private Key[] PQ;
    private int N; //# of elements
    
    public OrderedMaxPQ(){
        //Using resizing array
        PQ = (Key[]) new Comparable[1];
        N = 0;
    }
    
    public boolean isEmpty(){
        return N == 0;
    }

    
    public void insert(Key x){
        //Resize array if necessary
        if (N > PQ.length * 3 / 4){
            Key[] temp = (Key[]) new Comparable[PQ.length*2];
            for (int i = 0; i < PQ.length;i++){
                temp[i] = PQ[i];
            }
            PQ = temp;
        }
        
        if (N < PQ.length / 4){
            Key[] temp = (Key[]) new Comparable[PQ.length/2];
            for (int i = 0; i < PQ.length;i++){
                temp[i] = PQ[i];
            }
            PQ = temp;
        }
        
        int i = 0;
        if (N > i){
            while(less(PQ[i],x)){
                if (i < N) i++;
                if (i == N) break;
            }
        }
        
        Key prev = x;
        
        for (int j = i; i <= N; i++){
            Key temp = PQ[i];
            PQ[i] = prev;
            prev = temp;
        }
        
        N++;
    }
    
    public Key delMax(){
        Key temp = PQ[N-1];
        PQ[N-1] = null;
        N--;
        return temp;
    }
    
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) == -1;
    }
    
    public void printItems(){
        for (int i = 0; i < N; i++){
            System.out.println(PQ[i]);
        }
    }
}