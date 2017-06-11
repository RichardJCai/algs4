public class testPQ{
    public static void main(String args[]){
//        OrderedMaxPQ pq = new OrderedMaxPQ();
        BinaryHeap pq = new BinaryHeap();
        int[] array = {6,7,12,3,1,-11,0,-155,5,6,7,8,999,100};
//int[] array = {6};
        
        for (int item:array){
            pq.insert(item);
        }
        
        for (int i = 0; i < 6; i ++){
            System.out.print(pq.delMax());
        }
         System.out.print(pq.delMax());
        pq.printItems();
    }
}