/**
 * Created by JulianStellaard on 26/11/15.
 */

public class Guest {

    //Constructor
    private String name;
    public Room room;

    public Guest(String name){
        this.name = name;
    }

    //Methodes
    public String getName(){
        return name;
    }


    public Room getRoom(){
        return room;
    }

    public boolean checkIn(Room r){
        if(room == null && r.getGuest() == null){
            room = r;
            r.setGuest(this);
            return true;
        }
        return false;
    }

    public boolean checkOut(){
        if(room != null){
            room.setGuest(null);
            room = null;
            return true;
        }
        return false;
    }

    public String toString(String name){
        return "THe name of this person is:" + getName();
    }

    public static void main(String[] args) {
        Guest r = new Guest("harrie");
        System.out.println(r.toString("harrie"));
        System.out.println("hello");

    }
}
