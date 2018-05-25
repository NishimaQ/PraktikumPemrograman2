
package pertemuan6;

import java.util.LinkedList;

public class BinaryTree {
    public Node root;
    private LinkedList<Node> topView; 
    private int maxHeight, countedLeft=0, countedRight=0;//for counting height
    
    BinaryTree(){
        topView = new LinkedList<Node>();
        maxHeight = 0;
        
    }
    
    public void topViewLeft(Node parent){
        if(parent.leftChild != null) topViewLeft(parent.leftChild);
        this.topView.add(parent);
    }
    
    public void topViewRight(Node parent){
        this.topView.add(parent);
        if(parent.rightChild != null) topViewRight(parent.rightChild);
                
    }
    
    public void topView(){        
        topViewLeft(this.root);
        topViewRight(this.root.rightChild);
        System.out.println("\nTop View");
        for(Node node : this.topView){
            System.out.print(node.getValue()+" ");
        }
        
    }
    
    public void height(Node parent, int currHeight){
        int counter = currHeight;
        if(parent.leftChild != null){
            counter++;
            height(parent.leftChild, counter);
        }
        if(counter > this.maxHeight) this.maxHeight = counter;
        
        counter = currHeight;
        if(parent.rightChild != null){
            counter++;
            height(parent.rightChild, counter);
        }
        if(counter > this.maxHeight) this.maxHeight = counter;
        
        if(parent == this.root) System.out.println("\n"+this.maxHeight);
    }
    
    public void addNode(Node node){
        if(root==null){
            root = node;
        } else {
            insertNode(root, node);
        }
    }
    
    private void insertNode(Node parent, Node node){
        if(parent.getValue() > node.getValue()){
            if(parent.leftChild == null){
                parent.leftChild = node;
            } else {
                insertNode(parent.leftChild, node);
            }
        } else {
            if(parent.rightChild==null){
                parent.rightChild = node;
            } else {
                insertNode(parent.rightChild, node);
            }
        }
    }
    
    public boolean searchValue(Node root, int value){
        boolean result;
        if(root==null){
            result = false;
        } else {
            if(root.getValue()==value){
                result = true;
            } else if(root.getValue()>value){
                result = searchValue(root.leftChild, value);
            } else {
                result = searchValue(root.rightChild, value);
            }
        }
        return result;
    }
    
    public void deleteNode(Node root,int value){
        Node current = root;
        Node parent = root;
        boolean isLeft;
        while(current.getValue()!=value){
            if(current.getValue()<value) current = current.rightChild;
            else if (current.getValue()>value) current = current.leftChild;
        }        
        
        while((parent.getValue()!=value) && (parent.leftChild!= current) && (parent.rightChild!=current)){
            if(parent.getValue()<value) parent = parent.rightChild;
            else if (parent.getValue()>value) parent = parent.leftChild;
        }        
        
        if(parent.leftChild==current) isLeft = true;
        else isLeft = false;
            
        if((current.leftChild==null) && (current.rightChild==null)) {                
                if(isLeft) parent.leftChild = null;
                else parent.rightChild = null;
            } else {
                if(current.leftChild==null){
                    Node temp = current.rightChild;                    
                    if(isLeft){
                        parent.leftChild = null;
                        parent.leftChild = temp;                       
                    } else {
                        parent.rightChild = null;
                        parent.rightChild = temp;
                    }
                
                } else if(current.rightChild==null){                    
                    Node temp = current.leftChild;                    
                    if(isLeft){
                        parent.leftChild = null;
                        parent.leftChild = temp;                       
                    } else {
                        parent.rightChild = null;
                        parent.rightChild = temp;
                    }
                } else {
                    Node temp = current.leftChild;   
                    Node beNull = null;
                    while(temp.rightChild!=null){
                        if(temp.rightChild.rightChild==null){
                            beNull = temp;
                        }
                        temp = temp.rightChild;
                    }
                    
                    if(isLeft){
                        parent.leftChild = null;
                        parent.leftChild = temp;                       
                    } else {
                        parent.rightChild = null;
                        parent.rightChild = temp;
                    }
                    temp.rightChild=current.rightChild;
                    
                    if(beNull==null){                                                
                        temp.leftChild=null;
                    } else {
                        beNull.rightChild=null;
                        temp.leftChild=beNull;
                    }                                                           
                }
            }
        System.out.println("Node has been deleted~");        
    }
    
    public void displayNode(Node root){
        if(root != null){
            displayNode(root.leftChild);
            System.out.print(root.getValue()+" ");
            displayNode(root.rightChild);
        }
    }
}
