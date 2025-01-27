public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.generateBSTRecursive(100);
        bst.generateBSTRecursive(20);
        bst.generateBSTRecursive(150);
        bst.generateBSTRecursive(15);
        bst.generateBSTRecursive(130);
        bst.generateBSTRecursive(160);
        bst.generateBSTRecursive(10);
        bst.generateBSTRecursive(120);
        bst.generateBSTRecursive(131);
        bst.generateBSTRecursive(155);
        bst.generateBSTRecursive(170);
        bst.generateBSTRecursive(5);
        bst.generateBSTRecursive(14);
        bst.generateBSTRecursive(161);
        bst.generateBSTRecursive(175);
        bst.generateBSTRecursive(174);
        bst.generateBSTRecursive(176);
        System.out.println("BST created");
        bst.showBSTByLevels();

        System.out.println("Search 5");
        if (bst.search(bst.root, 5) != null) {
            System.out.println("found 5!");
        } else {
            System.out.println("not found");
        }

        System.out.println("Delete leaf");
        bst.deleteNode(100);
        System.out.println("BST updated!");
        bst.showBSTByLevels();

    }
}