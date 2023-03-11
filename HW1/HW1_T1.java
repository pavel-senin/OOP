
public class HW1_T1
{
    public static void main(String args[])
    {
        GenTree Root = new GenTree("A");
        Root.addTo("B", "F");
        Root.addTo("C", "M");
        Root.addTo("D", "S");
        Root.addTo("E", "S");
        Root.addTo("F", "C");
        Root.addTo("G", "C");
        System.out.println("Famile tree output");
        Root.ShowRelatives();
    }

    


}