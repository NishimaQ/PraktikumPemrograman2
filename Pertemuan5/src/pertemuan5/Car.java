
package pertemuan5;

public class Car {
    private String platNomor;
    private int parkingTime;
    
    public Car(String platNomor, int parkingTime){
        this.parkingTime = parkingTime;
        this.platNomor = platNomor;
    }
    
    public String toString(){
        return "Plat nomor : "+this.platNomor+" Lama Parkir : "+this.parkingTime
                +" Biaya parkir : "+(1000*this.parkingTime);
    }
}
