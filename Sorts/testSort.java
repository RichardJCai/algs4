public class testSort{
    public static void main (String args[]){
//        SelectionSort sort = new SelectionSort();
//        InsertionSort iSort = new InsertionSort();
//        ShellSort iSort = new ShellSort();
        MergeSort iSort = new MergeSort();
//        Comparable[] array = {4,5,1,2,3,7,9,4,4,3,1,0,-1,100,99,15};
        Comparable[] array = {5,4,3,2,1,0,-100};
        iSort.sort(array);
        
        for (int i = 0; i < array.length;i++){
            System.out.println(array[i]);
        }
    }
}