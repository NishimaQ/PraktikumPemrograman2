package dll;

import java.util.NoSuchElementException;

public class DLL<E> {

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        size = 0;
    }

    private class Node {

        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void addLast(E element) {
        Node tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }
    
    public void addSpecific(int position, E element){
        Node tmp = head;
        if(position>size+1) throw new NoSuchElementException();           
        else if(position==1) addFirst(element);
        else if(position==size+1) addLast(element);
        else {
            for(int i=1;i<position-1;i++){
                tmp = tmp.next;
            }
            Node tmpAdd = new Node(element, tmp.next, tmp);System.out.println("adding: " + element);
            tmp.next = tmpAdd;
            tmp.next.next.prev = tmpAdd;
            System.out.println("adding: " + tmpAdd.element);
        }        
        size++;        
    }

    public void iterateForward() {
        System.out.println("iterating forward..");
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void iterateBackward() {
        System.out.println("iterating backward..");
        Node tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }
    
    public E removeSpecific(int position){
        E returnValue = null;
        if(position==0 || size==0 || position>size){
            throw new NoSuchElementException();
        } else if(position==1){
            removeFirst();
        } else if (position==size){
            removeLast();
        } else {
            Node tmpRemoved = head;
            for(int i=1;i<position;i++){
                tmpRemoved = tmpRemoved.next;
            }            
            Node tmpFront = tmpRemoved.next;
            Node tmpBack = tmpRemoved.prev;
            tmpBack.next = tmpFront;
            tmpFront.prev = tmpBack;
            returnValue = tmpRemoved.element;
            System.out.println("deleted: " + returnValue);
        }
        size--;
        return returnValue;        
    }

    public static void main(String a[]) {
        DLL<Integer> dll = new DLL<Integer>();
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addLast(56);
        dll.addLast(364);
        dll.iterateForward();
        
        dll.addSpecific(3, 15);
        dll.iterateForward();
        dll.removeSpecific(3);
        dll.iterateForward();
//        dll.removeFirst();
//        dll.removeLast();
//        dll.iterateBackward();
    }
}
