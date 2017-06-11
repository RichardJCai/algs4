public class BinarySearchTree<Key extends Comparable<Key>, Value>{

  private Node root;

  private class Node{
    private Key key;
    private Value val;
    private Node left, right;
  }

  public void put(Key key, Value val){

  }

  public void insert(Node node, Key key, Value val){

  }

  public Value get(Key key){


  }

  public void delete(Key key){

  }

  public Iterable<Key> iterator(){

  }

  public static boolean less(Comparable v, Comparable w){
      return v.compareTo(w) == -1;
  }

}
