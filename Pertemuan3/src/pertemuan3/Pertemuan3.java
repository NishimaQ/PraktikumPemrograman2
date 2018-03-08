
package pertemuan3;
import java.io.IOException;
import java.util.Scanner;

class Node{
    public int iData;
    public Node next;
    
    public Node(int id){
        iData = id;
    }
    
    public void displayLink(){
        System.out.print("{" + iData + "} ");
    }
}

class LinkListInit{
    private Node first;
    
    public LinkListInit(){
        first = null;
    }
    
    public boolean isEmpty(){
        return(first==null);
    }
    
    public void insertFirst(int id){
        Node newNode = new Node(id);
        newNode.next = first;
        first = newNode;
    }
    
    public void insertLast(int id){
        if(first==null){
            insertFirst(id);
        } else {
            Node temp = first;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(id);
        }
    }
    
    public Node deleteFirst(){
        Node temp = first;
        first=first.next;
        
        return temp;
    }
    
    public Node deleteLast(){
        Node temp = first;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node toReturn = temp.next;
        temp.next = null;
        
        return toReturn;
    }
    
    public void inserAtSpecificNode(int i, int id){            
        try {
            if(i == 1){
                insertFirst(id);
            } else {
                int counter = 1;
                Node temp = first;        
                while((counter<i-1) && (temp != null)){
                    temp = temp.next;        
                    counter++;
                }
                Node insert = new Node(id);
                Node temptemp = temp.next;
                temp.next = insert;
                temp.next.next = temptemp;
            }
        } catch (java.lang.NullPointerException err) {
            System.out.println("Salah input coeg");            
        }
    }
    
    public void displayList(){
        System.out.print("List (first-->last) : ");
        Node current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

public class Pertemuan3 {

    public static void main(String[] args) throws IOException {
        LinkListInit theList1 = new LinkListInit();
        LinkListInit theList2 = new LinkListInit();
        Scanner in = new Scanner(System.in);
        int nodeNum1, nodeNum2, tempNum;
        
        System.out.print("First list size? ");
        nodeNum1 = in.nextInt();
        
        for(int i=0;i<nodeNum1;i++){
            System.out.print("Insert number : ");
            tempNum = in.nextInt();
            theList1.insertLast(tempNum);
        }
        theList1.displayList();
        
        theList1.inserAtSpecificNode(9, 17);
        theList1.displayList();
//        
//        System.out.print("Second list size? ");
//        nodeNum2 = in.nextInt();
//        
//        for(int i=0;i<nodeNum2;i++){
//            System.out.print("Insert number : ");
//            tempNum = in.nextInt();
//            theList2.insertFirst(tempNum);
//        }
//        theList2.displayList();
//        
//        System.out.println("\nDeleting first node of the first list");
//        theList1.deleteFirst();
//        theList1.displayList();
//        
//        System.out.println("\nDeleting last node of the second list");
//        theList2.deleteLast();
//        theList2.displayList();
    }
    
}
