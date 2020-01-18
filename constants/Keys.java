package constants;

public enum Keys
{
    UP(38), DOWN(40), LEFT(37), RIGHT(39), F(70), ESC(27), ENTER(10);
    
    private int value;
    
    Keys(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
}
