import java.util.*;
public class GenTree extends Human {
    private Human root = new Human();
    private Human father = new Human();
    private Human mother = new Human();

    public GenTree(String name) {
        this.root.setName(name);
    }

    public String getNameData() {
        return "Person is " + this.root.getName();
    }

    public ArrayList<Human> sibling = new ArrayList<>();
    public ArrayList<Human> child = new ArrayList<>();

    public void addTo(String name, String Status) {
        switch (Status) {
            case "F":
                this.father.setName(name);
                break;
            case "M":
                this.mother.setName(name);
                break;
            case "S":
                Human Adding1 = new Human();
                Adding1.setName(name);
                this.sibling.add(Adding1);
                break;
            case "C":
                Human Adding2 = new Human();
                Adding2.setName(name);
                this.child.add(Adding2);
                break;
            default:
                System.out.println("Don't know who is "+ Status);
        }
    }

    public void showRelatives() {
        System.out.println("I am " + this.root.getName());
        System.out.println("Mother - " + this.mother.getName());
        System.out.println("Father - " + this.father.getName());
        System.out.println("Siblings:");
        if (this.sibling.size() > 0) {
            for (int i = 0; i < this.sibling.size(); i++) {
                System.out.println(this.sibling.get(i).getName());
            }
        } else {
            System.out.println("No siblings");
        }
        System.out.println("Children");
        if (this.child.size() > 0) {
            for (int i = 0; i < this.child.size(); i++) {
                System.out.println(this.child.get(i).getName());
            }
        } else {
            System.out.println("No children");
        }
    }

    public void showRelativesByChoice() {
        System.out.println("Choose which relatives to choose: ");
        System.out.println("(M) - mother; (F) - father; (C) - children; (S) - siblings");
        Scanner scan = new Scanner(System.in);
        String status = scan.nextLine();
        switch (status) {
            case ("S"):
                if (this.sibling.size() > 0) {
                    for (int i = 0; i < this.sibling.size(); i++) {
                        System.out.println(this.sibling.get(i).getName());
                    }
                } else {
                    System.out.println("No siblings");
                }
                break;
            case ("C"):
                System.out.println("Children");
                if (this.child.size() > 0) {
                    for (int i = 0; i < this.child.size(); i++) {
                        System.out.println(this.child.get(i).getName());
                    }
                } else {
                    System.out.println("No children");
                }
                break;
            case ("M"):
                System.out.println("Mother - " + this.mother.getName());
                break;
            case ("F"):
                System.out.println("Father - " + this.father.getName());
                break;
            default:
                System.out.println("Don't know who is "+ status);
        }
    }
}