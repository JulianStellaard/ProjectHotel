/**
 * Created by JulianStellaard on 27/11/15.
 */
public class Hotel {

    private static String hotelName;
    private Password password;
    private Room room;
    private Safe safe;

    //Constructor

    public Hotel(String hotelName){
        this.hotelName = hotelName;
        this.password = new Password();
        room = new Room(1);
        room = new Room(2);
    }

    //Command

    public Room checkIn(String password, String nameOfGuest){
        if(getPassword().testWord(password) || getFreeRoom() == null || room.getGuest().getName().equals(nameOfGuest)){
            return null;
        }else {
            Guest guest = new Guest(nameOfGuest);
            guest.checkIn(room);
            return room;
        }
    }

    public boolean checkOut(String nameOfGuest){
        if(room.getGuest().getName() == nameOfGuest){
            room.getGuest().checkOut();
            safe.deActivate();
        }
        return false;
    }

    //Quarys
    public Password getPassword(){
        return this.password;
    }

    public Room getRoom(String nameOfGuest){
        if(room.getGuest() != null && room.getGuest().getName().equals(nameOfGuest)) {
            return room;
        }
        return null;
    }

    public Room getFreeRoom(){
        if(room.getGuest() == null){
            return room;
        }
        return null;
    }

    public String toString(){
        String result = "Hotal" + Hotel.hotelName + "has :" + " Room " + room.getNumber() + room.getGuest().toString();
        return result;
    }

    public static void main(String[] args) {

    }

}

