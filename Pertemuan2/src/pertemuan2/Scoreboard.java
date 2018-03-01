
package pertemuan2;


public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;
    
    public Scoreboard(int capacity){
        board = new GameEntry[capacity];
    }
    
    public void add(GameEntry e){
        if(this.numEntries<this.board.length){
            this.numEntries++;
        } else {
            System.out.println("Buu Buu, Desu wa~");
        }
        
        int newScore = e.getScore();
        int j = numEntries - 1;
        
        while(j>0 && board[j-1].getScore() < newScore){
            board[j] = board[j-1];
            j--;
        }
        board[j]=e;
    }
    
    public GameEntry remove(int i){
        GameEntry fak = board[i];
        board[i]=null;
        int j=i+1; int limit = numEntries-1;
        while(i<limit && j<limit+1){
            board[i] = board[j];
            i++; j++; 
        }
        numEntries--;        
        return fak;
    }
    
    public String toString(){
        String vacot = "";
        for(int i=0;i<this.numEntries;i++){
            vacot += i+1+". "+board[i].getName()+" - "+board[i].getScore()+"\r\n";
        }
        
        return vacot;
    }
    
}
