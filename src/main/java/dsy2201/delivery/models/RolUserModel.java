package dsy2201.delivery.models;

public class RolUserModel {
    //encapsulated id and rol atributes
    private int id;
    private String rol;
    
    public RolUserModel(int id, String rol) {
        this.id = id;
        this.rol = rol;
    }
    //getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }


    
}
