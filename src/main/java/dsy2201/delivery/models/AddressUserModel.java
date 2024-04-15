package dsy2201.delivery.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Class AddressUserModel Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
@Entity
@Table(name = "address_user_model")
public class AddressUserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "address", length = 128)
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserModel user;

    // Default constructor
    public AddressUserModel() {
    }

    // Constructor with parameters
    public AddressUserModel(int id, String address, UserModel user) {
        this.id = id;
        this.address = address;
        this.user = user;
    }

    // Getters and Setters
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
