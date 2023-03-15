import java.lang.*;
public class Main
{
    public static void main(String[] args)
    {
        GenTree Root = new GenTree("A");
        Root.addTo("B", "F");
        Root.addTo("C", "M");
        Root.addTo("D", "S");
        Root.addTo("E", "S");
        Root.addTo("F", "C");
        Root.addTo("G", "C");
        System.out.println("Family tree output");
        Root.showRelatives();
        System.out.println(Root.getNameData());
        Root.showRelativesByChoice();

    }
}