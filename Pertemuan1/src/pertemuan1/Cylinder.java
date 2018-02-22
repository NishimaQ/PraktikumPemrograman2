
package pertemuan1;

public class Cylinder extends Circle{
    private double height;
    
    public Cylinder(){
        
    }
     public Cylinder(int height){
         this.height = height;
     }
     
     public Cylinder(double height,double radius){
         super(radius);
         this.height = height;
     }
     
     public double getHight(){
         return this.height;
     }
     
     public void setHight(double hight){
         this.height = height;
     }
     
     public double getVolume(){
         return getArea()*this.height;
     }
     
     public String toString(){
         return "Tabung dengan tinggi "+this.height+", mempunyai volume "+ this.getVolume();
     }
             
}
