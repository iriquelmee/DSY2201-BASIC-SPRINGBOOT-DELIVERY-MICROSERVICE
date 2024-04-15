package dsy2201.delivery.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import java.util.List;

//Class UserModel Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
@Entity
@Table(name = "usermodel")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "lastName", length = 128)
    private String lastName;

    @Column(name = "mail", length = 128)
    private String mail;

    @Column(name = "phone_contact", length = 128)
    private String phoneContact;

    @ManyToMany
    @JoinTable(
        name = "user_rol", 
        joinColumns = @JoinColumn(name = "id_user"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<RolUserModel> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AddressUserModel> addresses;

    // Constructor with parameters
    public UserModel(int id, String name, String lastName, String mail, String phoneContact, List<RolUserModel> roles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneContact = phoneContact;
        this.roles = roles;
    }

    // Default constructor
    public UserModel() {
    } 

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
