package constants;

public enum States
{
    MENU(0), GAME(1), FINISHED(2);
    
    private int value;
    
    States(int value){
        this.value = value;
    }
    
    public int getvalue(){
        return this.value;
    }
}
