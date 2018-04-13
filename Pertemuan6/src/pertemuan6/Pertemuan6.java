
package pertemuan6;

public class Pertemuan6 {

    public static void main(String[] args) {
        BinaryTree  bt = new BinaryTree();
        
        bt.addNode(new Node(3));
        bt.addNode(new Node(8));
        bt.addNode(new Node(1));
        bt.addNode(new Node(4));
        bt.addNode(new Node(6));
        bt.addNode(new Node(2));
        bt.addNode(new Node(10));
        bt.addNode(new Node(9));
        bt.addNode(new Node(20));
        bt.addNode(new Node(25));
        bt.addNode(new Node(15));
        bt.addNode(new Node(16));        
        
        System.out.println(bt.searchValue(bt.root, 3));
        bt.displayNode(bt.root);
        System.out.println("");
        
        bt.deleteNode(bt.root,10);
        bt.displayNode(bt.root);
        
    }
    
}
