import java.util.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value>{

  private Node root;

  public class Node{
    private Key key;
    private Value val;
    public Node left, right;

    public Node(Key key, Value val){
      this.key = key;
      this.val = val;
    }
  }

  public void put(Key key, Value val){
    root = put(root,key,val);
  }

  public Node put(Node node, Key key, Value val){
    if (node == null) return new Node(key,val);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = put(node.left,key,val);
    else if (cmp > 0) node.right = put(node.right,key,val);
    return node;
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
