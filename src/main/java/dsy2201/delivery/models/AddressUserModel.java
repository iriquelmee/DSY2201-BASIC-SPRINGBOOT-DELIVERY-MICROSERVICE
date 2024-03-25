package dsy2201.delivery.models;

//Created and mantained by Ignacio Eduardo Riquelme Erazo
public class AddressUserModel {

    //encapsulated id and addres
    private int id;
    private String address;
    
    //constructor 
    public AddressUserModel(int id, String address) {
        this.id = id;
        this.address = address;
    }
    //getters and setters methods
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    


    
}
