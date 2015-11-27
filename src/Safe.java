/**
 * Created by JulianStellaard on 26/11/15.
 */
public class Safe {

    private boolean status;
    private boolean door;
    private Password password;

    //Constructer
    public Safe(){
        this.status = false;
        this.door = false;
        this.password = new Password();
    }

    //Commands

    public boolean activate(String myPass){
        if(password.testWord(myPass)){
            status = true;
            return true;
        }else{
            return false;
        }

    }

    public boolean deActivate(){
        door = false;
        status = false;
        return false;
    }

    public boolean open(String myPass){
        if(status == true && password.testWord(myPass)){
            door = true;
            return true;
        } else{
            return false;
        }
    }

    public boolean close(){
        door = false;
        return false;
    }

    //Queries

    public boolean isActive(){
        return status;
    }

    public boolean isOpen(){
        return door;
    }

    public Password getPassword(){
        return this.password;
    }

    public static void main(String[] args) {
        Safe s = new Safe();
        System.out.println(s.isActive());
        System.out.println(s.isOpen());
        s.activate("Test");
        System.out.println(s.isActive());
        s.open("Test");
        System.out.println(s.isOpen());
        s.deActivate();
        System.out.println(s.isActive());
        s.close();
        s.open("Test");
        System.out.println(s.isOpen());

    }
}