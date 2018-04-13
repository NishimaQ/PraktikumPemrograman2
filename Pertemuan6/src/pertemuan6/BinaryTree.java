
package pertemuan6;

public class BinaryTree {
    public Node root;
    
    BinaryTree(){
        
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
    
    public void displayNode(Node root){
        if(root != null){
            displayNode(root.leftChild);
            System.out.print(root.getValue()+" ");
            displayNode(root.rightChild);
        }
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
}
