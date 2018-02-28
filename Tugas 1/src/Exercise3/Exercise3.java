
package Exercise3;


public class Exercise3 {
    public static void main(String[] args) {
        Square persegi = new Square(14,"red",false);
        System.out.println(persegi);
        System.out.println("Area        = "+persegi.getArea());
        System.out.println("Perimeter   = "+persegi.getPerimeter());
        System.out.println("");
        
        Circle lingkaran = new Circle(14.0,"blue",true);
        System.out.println(lingkaran);
        System.out.println("Area        = "+lingkaran.getArea());
        System.out.println("Perimeter   = "+lingkaran.getPerimeter());
        System.out.println("");
        
        Rectangle pPanjang = new Rectangle(7,7,"green",false);
        System.out.println(pPanjang);
        System.out.println("Area        = "+pPanjang.getArea());
        System.out.println("Perimeter   = "+pPanjang.getPerimeter());
        System.out.println("");
        
        
        
    }
}
