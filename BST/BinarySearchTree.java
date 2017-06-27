import java.util.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value>{

  private Node root;

  public class Node{
    private Key key;
    private Value val;
    public int size; //# of nodes in the subtree
    public Node left, right;

    public Node(Key key, Value val,int size){
      this.key = key;
      this.val = val;
      this.size = size;
    }
  }

  public void put(Key key, Value val){
    root = put(root,key,val);
  }

  public Node put(Node node, Key key, Value val){
    if (node == null) return new Node(key,val,1);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = put(node.left,key,val);
    else if (cmp > 0) node.right = put(node.right,key,val);
    node.size = 1 + size(node.right) + size(node.left);
    return node;
  }

  public int size(){
    return size(root);
  }

  private int size(Node node){
    if (node == null) return 0;
    else return node.size;
  }

  public Value get(Key key){
    Node currentNode = root;

    while (currentNode != null){
      if (key.compareTo(currentNode.key) < 0) currentNode = currentNode.left;
      else if (key.compareTo(currentNode.key) > 0) currentNode = currentNode.right;
      else return currentNode.val;
    }
    return null;
  }

  public Key floor(Key key){
    return floor(key,root).key;
  }

  public Node floor(Key key,Node node){
    if (node == null) return null;

    int cmp = key.compareTo(node.key);
    if (cmp == 0) return node;
    else if (cmp < 0) return floor(key,node.left);
    else{ //(cmp > 0)
      Node retNode = floor(key,node.right);
      if (retNode != null) return retNode;
      else return node;
    }
  }

  public Key ceil(Key key){
    //Recursive implmentation of ceil
    return ceil(key,root).key;
  }

  private Node ceil(Key key, Node node){
    if (node == null) return null;
    int cmp = key.compareTo(node.key);
    if (cmp == 0) return node;
    else if (cmp < 0){
      Node retNode = ceil(key,node.left);
      if (retNode != null) return retNode;
      else return node;
    }
    return ceil(key,node.right);
  }

  public void deleteKey(Key key){
    root = deleteKey(key,root);
  }

  private Node deleteKey(Key key,Node node){
    if (node == null) return null;
    int cmp = key.compareTo(node.key);
    if (cmp == 0){
      if (node.right == null && node.left == null){
        return null;
      }
      else if (node.right == null){
        return node.left;
      }
      else if (node.left == null){
        return node.right;
      }
      else{
        return deleteMin(node.right);
      }
    }
    else if (cmp > 0) node.right = deleteKey(key,node.right);
    else if (cmp < 0) node.left = deleteKey(key,node.left);

    return node;
  }

  public void deleteMin(){
    root = deleteMin(root);
  }

  private Node deleteMin(Node node){
    if (node.left != null){
      node.left = deleteMin(node.left);
    }
    else{
      return node.right;
    }
    return node;
  }

  public void deleteMax(){
    root = deleteMax(root);
  }

  private Node deleteMax(Node node){
    if (node.right != null){
      node.right = deleteMax(node.right);
    }
    else{
      return node.left;
    }
    return node;
  }

  public Iterable<Key> iterator(){
    Queue<Key> q = new LinkedList<Key>();
    inorder(root,q);
    return q;
  }

  private void inorder(Node x, Queue<Key> q){
    if (x == null) return;
    inorder(x.left,q);
    q.add(x.key);
    inorder(x.right,q);
  }


}
