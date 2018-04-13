
package pertemuan5;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<E> {
    private LinkedList<E> object;
    
    public Queue(){
        this.object = new LinkedList<E>();
    }
    
    public void enqueue(E n){
        this.object.addLast(n);
    }
    
    public E dequeue(){
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
        for(Iterator<E> i = object.iterator(); i.hasNext(); ){
            System.out.println(i.next());
        }
    }
}
