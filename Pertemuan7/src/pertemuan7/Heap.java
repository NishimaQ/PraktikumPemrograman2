
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
        if(!isEmpty()){
            Node root = heapArray[0];
            heapArray[0] = heapArray[--currentSize];
            trickleDown(0);
            return root;
        } else {
            System.out.println("There's no object in the array~");
            return null;
        }
    }
    
    public void trickleDown(int index){
        int largerChild;
        Node top = heapArray[index];        
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
        Node[] original = new Node[currentSize];
        Node[] sorted = new Node[currentSize];
        int originalSize = currentSize;
        
        for(int i=0;i<originalSize;i++){              
                int temp = heapArray[i].getKey();
                original[i] = new Node(temp);
            }
        
        if(!isEmpty()){
            for(int i=0;i<originalSize;i++){
                sorted[i] = remove();
            }
            
            for(int i=0;i<originalSize;i++){
                int temp = original[i].getKey();
                this.insert(temp);
            }            
            
            System.out.println("Ascending :");
            for(int i=0;i<currentSize;i++) System.out.print(sorted[i].getKey()+" ");
            System.out.println("\nDescending :");
            for(int i=currentSize-1;i>0;i--) System.out.print(sorted[i].getKey()+" ");
            System.out.println(sorted[0].getKey());
            
        } else System.out.println("There's no object in the array~");
    }
    
    public void swap(int i, int j){
        if(!isEmpty() && this.currentSize !=1 && i<this.currentSize && j<this.currentSize){            
            Node temp = heapArray[--i];
            heapArray[i] = heapArray[--j];
            heapArray[j] = temp;
            System.out.println("The Node has been swapped~");
            //trickleDown(i);   Saya tidak tahu apakah setelah diswap, perlu di trcikleDown() atau tidak
            //                  Jadi saya taruh comment di sini untuk ditanyakan di kelas
        } else System.out.println("This method can't be executed~");
    }
    
    public void displayNode(){
        if(!isEmpty()){
            System.out.print("Contained array = ");
            for(int i=0;i<this.currentSize-1;i++){
                System.out.print(heapArray[i].getKey()+" ");
            }
            System.out.println(heapArray[this.currentSize-1].getKey());
        } else System.out.println("There's no object in the array~");
    }
}
