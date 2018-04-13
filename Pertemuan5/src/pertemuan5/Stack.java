
package pertemuan5;

import java.util.LinkedList;
import java.util.Iterator;

public class Stack<E> {
    private LinkedList<E> object;
    
    public Stack(){
        this.object = new LinkedList<E>();
    }
    
    public void push(E n){
        this.object.addFirst(n);
    }
    
    public E pop(){
        if(!this.object.isEmpty()){
            E n = this.object.removeFirst();
            return n;
        } else {
            System.out.println("The Object is Empty~");
            return null;
        }
    }
    
    public E peek(){
        return this.object.getFirst();
    }
    
    public void returnObject(){
        for(int i=object.size()-1;i>=0;i--){
            System.out.println(object.get(i));
        }
    }
}
