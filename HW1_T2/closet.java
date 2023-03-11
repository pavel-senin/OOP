public class closet {
    closet(){
        this.status = "закрыт";
    }
    private String status;
    public void toOpen(){
        if (this.status.equals("открыт")){
            System.out.println("Шкаф уже " + this.status);
        }
        else{
            this.status = "открыт";
            System.out.println("Шкаф " + this.status);
        }
    }
    public void toClose(){
        if (this.status.equals("закрыт")){
            System.out.println("Шкаф уже " + this.status);
        }
        else{
            this.status = "закрыт";
            System.out.println("Шкаф " + this.status);
        }
    }
}
