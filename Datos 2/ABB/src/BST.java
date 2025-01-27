import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node root;

    public void recursiveInsert(Node root, Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            if (root.data > newNode.data) {
                if (root.left == null) {
                    root.left = newNode;
                } else recursiveInsert(root.left, newNode);

            } else {
                if (root.right == null) {
                    root.right = newNode;
                } else recursiveInsert(root.right, newNode);
            }
        }
    }

    public void generateBSTRecursive(int theData) {
        Node newNode = new Node(theData);
        if (root == null) {
            root = newNode;
        } else recursiveInsert(root, newNode);
    }

    public void showBSTByLevels() {
        if (root != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        } else {
            System.out.println("Empty Tree!");
        }
    }

    public Node search(Node root, int theData) {
        if (root == null) {
            return null;
        } else if (root.data == theData) {
            return root;
        } else if (root.data > theData) {
            return search(root.left, theData);
        } else {
            return search(root.right, theData);
        }
    }

    public Node foundFather(Node root, Node father, int theData) {
        if (root.data == theData) {
            return father;
        } else if (root.data > theData) {
            return foundFather(root.left, root, theData);
        } else return foundFather(root.right, root, theData);
    }

    public void deleteNode(int element) {
        if (root.data == element && root.left == null && root.right == null) {
            root = null;
        } else {
            Node node2delete = search(root, element);
            if (node2delete != null) {
                // case 1 leaf!
                if (node2delete.left == null && node2delete.right == null) {
                    System.out.println("Deleting leaf");
                    Node father = foundFather(root, null, element);
                    System.out.println("Father: " + father.data);
                    if (father.left.data == element) {
                        father.left = null;
                    } else father.right = null;
                    System.gc();
                    // case 2 one son
                } else if (node2delete.left != null && node2delete.right == null) {
                    System.out.println("Deleting node with one son!");
                    Node father = foundFather(root, null, element);
                    System.out.println("Father: " + father.data);
                    if (father.left.data == element) {
                        father.left = node2delete.left;
                    } else father.right = node2delete.right;
                    System.gc();
                } else if (node2delete.left == null) {
                    System.out.println("Deleting node with one son!");
                    Node father = foundFather(root, null, element);
                    System.out.println("Father: " + father.data);
                    if (father.right.data == element) {
                        father.right = node2delete.right;
                    } else father.left = node2delete.left;
                    // 3rd case
                } else {
                    System.out.println("Deleting node with two sons!");
                }
            }
        }
    }
}
