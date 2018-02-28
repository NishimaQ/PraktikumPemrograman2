
package Exercise1;

public class Exercise1 {
    
    public static void main(String[] args) {
        Customer human = new Customer(1998,"NishimaQ",50);
        Invoice invoice = new Invoice(human.getID(),human,450);
        
        System.out.println("Customer's profil :");
        System.out.println("ID      : "+invoice.getID());
        System.out.println("Name    : "+invoice.getCustomerName());
        System.out.println("");
        System.out.println("Good's price    = "+invoice.getAmount());
        System.out.println("Discount        = "+human.getDiscount());
        System.out.println("After discount  = "+invoice.getAmountAfterDiscount());        
    }
    
}
