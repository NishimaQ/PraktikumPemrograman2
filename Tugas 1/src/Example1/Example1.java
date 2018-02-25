
package Example1;

public class Example1 {
    
    public static void main(String[] args) {
        Customer manusia = new Customer(1998,"NishimaQ",50);
        Invoice bacot = new Invoice(manusia.getID(),manusia,450);
        System.out.println(bacot.getAmountAfterDiscount());
    }
    
}
