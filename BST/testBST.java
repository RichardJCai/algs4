public class testBST extends BinarySearchTree{
  public static void main(String args[]){
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(10,10);
    bst.put(6,6);
    bst.put(11,11);
    bst.put(7,7);
    bst.put(12,12);
    bst.put(3,3);
    bst.put(5,5);
    bst.put(24,24);
    bst.put(1,1);
    System.out.println(bst.floor(8));
    System.out.println(bst.ceil(15));
    System.out.println(bst.size());
    Iterable iterator = bst.iterator();
    // while (iterator.hasNext()){
    //   System.out.print(iterator.next());
    // }
    System.out.print(iterator);
  }
}
