
package pertemuan5;


public class Pertemuan5 {

    public static void main(String[] args) {
        Car a = new Car("abcde", 5);
        Car b = new Car("fghij", 4);
        Car c = new Car("klmno", 3);
        Car d = new Car("pqrst", 2);
        Car e = new Car("uvwxy", 1);
        
        
        
        Stack<Car> aa = new Stack<Car>();
        Queue<Car> bb = new Queue<Car>();
        
        aa.push(a);
        aa.push(b);
        aa.push(c);
        
        aa.returnObject();
        
        
        
        
    }
    
}
