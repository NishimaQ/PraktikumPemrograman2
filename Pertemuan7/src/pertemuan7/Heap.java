
package pertemuan7;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    
    public Heap(int max){
        this.maxSize = max;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }
    
    public boolean isEmpty(){
        return this.currentSize == 0;
    }
    
    public boolean insert(int key){
        if(this.currentSize == this.maxSize){
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(this.currentSize++);
        return true;
    }
    
    public void trickleUp(int index){
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];
        
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1) / 2;
        }
        heapArray[index] = bottom;
    }
    
    public Node remove(){
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown();
        return root;
    }
    
    public void trickleDown(){
        int largerChild;
        Node top = heapArray[0];
        int index = 0;
        while(index < currentSize/2){
            int leftChild = 2*index+1;
            int rightChild = leftChild +1;
            
            if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()){
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            
            if(top.getKey() >= heapArray[largerChild].getKey()){
                break;
            }
            
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        
        heapArray[index] = top;            
    }
    
    public void sorting(){
        Node[] original = heapArray;
        Node[] sorted = new Node[currentSize];
        int originalSize = currentSize;
        
        for(int i=0;i<originalSize;i++){
            sorted[i] = remove();
        }
        
        heapArray = original;
        currentSize = originalSize;
        
        System.out.println("Ascending :");
        for(int i=0;i<currentSize;i++) System.out.print(sorted[i].getKey()+" ");
        System.out.println("\nDescending :");
        for(int i=currentSize-1;i>=0;i--) System.out.print(sorted[i].getKey()+" ");
    }
    
    public void displayNode(){
        System.out.print("Contained array = ");
        for(int i=0;i<this.currentSize;i++){
            System.out.print(heapArray[i].getKey()+" ");
        }           
    }
}
