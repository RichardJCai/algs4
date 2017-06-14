public class testBST extends BinarySearchTree{
  public static void main(String args[]){
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1,1);
    bst.put(2,2);
    bst.put(7,2);
    bst.put(0,2);
    bst.put(-100,2);
    bst.put(-1,2);
    bst.put(3,2);
    bst.delete(1);
    Iterable iterator = bst.iterator();
    // while (iterator.hasNext()){
    //   System.out.print(iterator.next());
    // }
    System.out.print(iterator);
  }
}
