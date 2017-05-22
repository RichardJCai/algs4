public class testSort{
    public static void main (String args[]){
//        SelectionSort sort = new SelectionSort();
//        InsertionSort iSort = new InsertionSort();
        ShellSort iSort = new ShellSort();
//        Comparable[] array = {4,5,1,2,3,7,9,4,4,3,1,0,-1,100,99,15};
        Comparable[] array = {5,4,3,2,1};
        Comparable[] sorted = iSort.sort(array);
        
        for (int i = 0; i < sorted.length;i++){
            System.out.print(sorted[i]);
        }
    }
}