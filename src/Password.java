/**
 * Created by JulianStellaard on 26/11/15.
 */
public class Password {

    //Field methodes
    public static String INITIAL = "Test";
    private String password;

    //Constructor
    public Password() {
        password = INITIAL;
    }

    public boolean acceptable(String suggestion) {
        if (suggestion.length() < 6 || suggestion.contains(" ")){
            return false;
        }else {
            return true;
        }
    }

    public boolean testWord(String test){
        if(password.equals(test)){
            return true;
        }
        return false;
    }

    public boolean setWord(String oldpass, String newpass) {
        if (acceptable(newpass) && testWord(oldpass)) {
            password = newpass;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Password p = new Password();
        System.out.println(p.password);
        //p.acceptable("Testtest");
        //System.out.println(p.acceptable("Testtest"));
        //p.setWord("Test", "Testtest");
        //System.out.println(p.password);
    }
}
