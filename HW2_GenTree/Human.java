import java.lang.*;
public class Human {
    private String name;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public Human(){
        this.name="";
    }
    public Human(String name){
        this.name=name;
    }
}
