
package Example2;

public class Container {
    private int x1, y1, x2, y2;
    
    public Container(int x, int y, int width, int height){
        x1=x; y1=y;
        x2 = x1+width;
        y2 = y2+height;
    }
    
    public int getX(){
        return this.x1;
    }
    
    public int getY(){
        return this.y2;
    }
    
    public int getWidth(){
        return this.x2;
    }
    
    public int getHeight(){
        return this.y2;
    }
    
    public boolean collides(Ball ball){
        if (ball.getX() - ball.getRadius() <= this.x1 ||
            ball.getX() - ball.getRadius() >= this.x2) {
           ball.reflectHorizontal();
        }
        if (ball.getY() - ball.getRadius() <= this.y1 ||
            ball.getY() - ball.getRadius() >= this.y2) {
           ball.reflectVertical();
        }
        return true;
    }
    
    public String toString(){
        return "Container[("+this.x1+","+this.y1+"),("
                +this.x2+","+this.y2+")]";
    }
}
