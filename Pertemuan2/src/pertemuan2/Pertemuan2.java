
package pertemuan2;

public class Pertemuan2 {

    public static void main(String[] args) {
        Scoreboard klasemen = new Scoreboard(5);      
        
        GameEntry human1 = new GameEntry("NishimaQ",45);
        GameEntry human2 = new GameEntry("NishimaQ",99);
        GameEntry human3 = new GameEntry("NishimaQ",30);
        GameEntry human4 = new GameEntry("NishimaQ",55);
        GameEntry human5 = new GameEntry("NishimaQ",100);
        
        klasemen.add(human1);
        klasemen.add(human2);               
        klasemen.add(human3);
        klasemen.add(human4);
        klasemen.add(human5);
        
        System.out.println(klasemen);
        
        klasemen.remove(4);
        
        System.out.println(klasemen);
    }
    
}
