package constants;

public enum DisplayValues
{
    ROWCOUNT(12), DISPLAYWIDTH(768), DISPLAYHEIGHT(768), COLUMNCOUNT(12), TILEWIDTH(64);
    
    private int value;
    
    DisplayValues(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
}
