import java.util.*;

public class RedBlackBST<Key extends Comparable<Key>, Value>{

  private Node root;

  public class Node{
    private Key key;
    private Value val;
    private int size; //# of nodes in the subtree
    private Node left, right;
    private Boolean color; //Red = True, Black = False

    public Node(Key key, Value val, int size, Boolean color){
      this.key = key;
      this.val = val;
      this.size = size;
      this.color = color;
    }
  }

  public void put(Key key, Value val){
    root = put(root,key,val);
  }

  public Node put(Node node, Key key, Value val){
    if (node == null) return new Node(key,val,1,true);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = put(node.left,key,val);
    else if (cmp > 0) node.right = put(node.right,key,val);

    if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
    if (isRed(node.right) && isRed(node.left)) switchColors(node);

    node.size = 1 + size(node.right) + size(node.left);

    return node;
  }

  private Node rotateRight(Node node){
    Node x = node.left;
    node.left = x.right;
    x.right = node;
    x.color = x.right.color;
    x.size = node.size;
    node.size = size(node.left) + size(node.right) + 1;
    return x;
  }

  private Node rotateLeft(Node node){
    Node x = node.right;
    node.right = x.left;
    x.left = node;
    x.color = x.left.color;
    x.size = node.size;
    node.size = size(node.left) + size(node.right) + 1;
    return x;
  }

  private void switchColors(Node node){
    node.color = !node.color;
    node.left.color = !node.left.color;
    node.right.color = !node.right.color;
  }

  private boolean isRed(Node node){
    if (node == null) return false;
    if (node.color == true) return true;
    else return false;
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

  public void delete(Key key){
    Node currentNode = root;

    while (currentNode != null){
      if (key.compareTo(currentNode.key) < 0) currentNode = currentNode.left;
      else if (key.compareTo(currentNode.key) > 0) currentNode = currentNode.right;
      else break;
    }

    if (currentNode.left == null && currentNode.right != null){
      currentNode = currentNode.right;
    }
    else if (currentNode.left != null && currentNode.right == null){
      currentNode = currentNode.left;
    }
    else {
      //Find smallest in right subtree
      Node tempNode = currentNode.right;
      // while (tempNode.left != null){
      //   tempNode = tempNode.left;
      // }

      if (currentNode.left != null){
        tempNode.left = currentNode.left;
      }
      if (currentNode.right != null){
        tempNode.right = currentNode.right;
      }

      currentNode = tempNode;
    }
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
