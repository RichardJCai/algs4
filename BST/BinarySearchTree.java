public class BinarySearchTree<Key extends Comparable<Key>, Value>{

  private Node root;

  private class Node{
    private Key key;
    private Value val;
    private Node left, right;
  }

  public void put(Key key, Value val){
    root = put(root,key,val);
  }

  public Node put(Node node, Key key, Value val){
    if (node == null) return new Node(key,val);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) put(node.left,key,val);
    else if (cmp > 0) put(node.right,key,val);
    return node;
  }

  public Value get(Key key){
    Node currentNode = root;

    while (currentNode != null){
      if (key.compareTo(currentNode.key) < 0) currentNode = currentNode.left;
      else if (key.compareTo(currentNode.key) > 0) currentNode = currentNode.right;
      else return currentNode.val;
    }
  }

  public void delete(Key key){
    Node currentNode = root;

    while (currentNode != null){
      if (key.compareTo(currentNode.key) < 0) currentNode = currentNode.left;
      else if (key.compareTo(currentNode.key) > 0) currentNode = currentNode.right;
    }

    if (currentNode){
      if (currentNode.left == null && currentNode.right != null){
        currentNode = currentNode.right;
      }
      else if (currentNode.left != null && currentNode.right == null){
        currentNode = currentNode.left;
      }
      else {
        //Find smallest in right subtree
        Node tempNode = currentNode.right;
        while (tempNode.left != null){
          tempNode = tempNode.left;
        }

        currentNode.key = tempNode.key;
        currentNode.val = tempNode.val;

        tempNode = null;
      }
    }
    //Find the key, if cannot be found, exit
    //If found, if it only has one child, delete and let the one child be successor
    //If it has 2 children, swap the key with the smallest in the left tree and then delete
  }

  public Iterable<Key> iterator(){

  }

}
