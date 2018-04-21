
package pertemuan7;

public class Pertemuan7 {

    public static void main(String[] args) {
        Heap uwaw = new Heap(6);
        
        uwaw.insert(72);
        uwaw.insert(72);
        uwaw.insert(34);
        uwaw.insert(26);
        uwaw.insert(66);
        uwaw.insert(9);
        
        uwaw.displayNode();
        System.out.println("");
        
        uwaw.sorting();
    }
    
}
