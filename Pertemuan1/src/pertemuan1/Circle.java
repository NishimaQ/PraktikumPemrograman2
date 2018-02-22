
package pertemuan1;

public class Circle {
    private double radius = 1.0;
    
    public Circle(){
        
    }
    
    public Circle(double r){
        this.radius = r;
    }
    
    public double getRadius(){
        return this.radius;
    }
    
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    
    public String toString(){
        return("Jari-jarinya = "+this.radius+", Areanya = "+this.getArea());
    }
}
