public class OrderedMaxPQ<Key extends Comparable<Key>>{
    private Key[] PQ;
    private int N; //# of elements
    
    public void OrderedMaxPQ(){
        //Using resizing array
        Key[] PQ = (Key[]) new Comparable[2];
    }
    
    public boolean isEmpty(){
        return N == 0;
    }
    
    public void insert(Key x){
        //Resize and sort in here
        if (N > PQ.length * 3 / 4){
            Key[] temp = (Key[]) new Comparable[PQ.length*2];
            for (int i = 0; i < PQ.length;i++){
                temp[i] = PQ[i];
            }
            PQ = temp;
        }
        
        if (N > PQ.length / 2){
            Key[] temp = (Key[]) new Comparable[PQ.length/2];
            for (int i = 0; i < PQ.length;i++){
                temp[i] = PQ[i];
            }
            PQ = temp;
        }
        
    }
    
    public Key delMax(){
        Key temp = PQ[N];
        PQ[N] = null;
    }
}