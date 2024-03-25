package dsy2201.delivery.models;
import java.util.List;

public class UserModel {

    //encapsulated atributes only accesed by its setters and getters metho
    private int id;
    private List<RolUserModel> roles;
    private List<AddressUserModel> addresses;
    private String name;
    private String lastName;
    private String mail;
    private String phoneContact;

    //this constructor set an instance of this user model class with given parameters


    public UserModel() {
        this.id = 0;
        this.name = "";
        this.lastName = "";
        this.mail = "";
        this.phoneContact = "";
        this.roles = null;
        this.addresses = null;
    }
    
    public UserModel(int id, String name, String lastName,String mail, String phoneContact, List<RolUserModel> roles, List<AddressUserModel> addresses) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneContact = phoneContact;
        this.roles = roles;
        this.addresses = addresses;
    }
    //getters and setters for this models incluede rol model and address model as lists atributes
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<RolUserModel> getRoles() {
        return roles;
    }
    public void setRoles(List<RolUserModel> roles) {
        this.roles = roles;
    }
    public List<AddressUserModel> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<AddressUserModel> addresses) {
        this.addresses = addresses;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPhoneContact() {
        return phoneContact;
    }
    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }
        
}
