
import java.util.*;
public class GenTree extends Human{
    public Human Father;
    public Human Mother;
    public GenTree(String Name){
        this.Name = Name;
    }
    public List<Human> Sibling = new ArrayList<>();
    public List<Human> Child = new ArrayList<>();
    public void addTo(String Name, String Status){
        switch (Status){
        case "F":
            this.Father.Name = Name;
            break;
        case "M":
            this.Mother.Name = Name;
            break;
        case "S":
            Human Adding1 = new Human();
            Adding1.Name = Name;
            this.Sibling.add(Adding1);
            break;
        case "C":
            Human Adding2 = new Human();
            Adding2.Name = Name;
            this.Child.add(Adding2);
            break;
        }
    }
    public void ShowRelatives(){
        System.out.println("Mother - " + this.Mother);
        System.out.println("Father - " + this.Father);
        System.out.println("Siblings:");
        System.out.println(this.Sibling);
        System.out.println("Children");
        System.out.println(this.Child);
    }
}
