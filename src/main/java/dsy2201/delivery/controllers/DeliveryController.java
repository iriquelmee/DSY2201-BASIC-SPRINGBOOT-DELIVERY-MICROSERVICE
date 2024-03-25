package dsy2201.delivery.controllers;
import dsy2201.delivery.models.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Class Controller Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
@RestController
public class DeliveryController {
    
    //Setting preliminar data by: IGNACIO EDUARDO RIQUELME ERAZO.
    DeliveryController()
    {
        this.setUserData();
    }
    //Setting ArrayList data from UserModel by: IGNACIO EDUARDO RIQUELME ERAZO.
    private List<UserModel> users = new ArrayList<>();

    //Setting preliminar data by: IGNACIO EDUARDO RIQUELME ERAZO.
    public void setUserData()
    {
        //define address and roles for many users
        List<RolUserModel> rolAdminList = new ArrayList<>();
        RolUserModel        role1Admin1 = new RolUserModel(1, "ADMIN");
        RolUserModel        role2Admin1 = new RolUserModel(2, "NORMAL");

        //address admin
        List<AddressUserModel> addressAdminList = new ArrayList<>();
        AddressUserModel   addresAdmin1 = new AddressUserModel(1, "calle falsa 123");

        //appendig data to admin data list with 2 roles and 1 address
        rolAdminList.add(role1Admin1);
        rolAdminList.add(role2Admin1);
        addressAdminList.add(addresAdmin1);

        //creating admin user
        UserModel adminUser = new UserModel(
            1,            
            "Igancio",  
            "Riquelme", 
            "i.riquelmee@duocuc.cl", 
            "930535935",
            rolAdminList,       
            addressAdminList
        );
        
        //roles normal user.
        List<RolUserModel> rolNormalUserList = new ArrayList<>();
        RolUserModel          role1User2= new RolUserModel(2, "NORMAL");

        //addresess normal user.
        List<AddressUserModel> addressNormalUserList = new ArrayList<>();
        AddressUserModel    addres1User2= new AddressUserModel(1, "fondo de bikini 24");
        AddressUserModel    address2User2= new AddressUserModel(2, "crustaceo cascarudo 1, fondo de bikini");

        //creating normal user adding 1 rol and 2 addresses.
        rolNormalUserList.add(role1User2);
        addressNormalUserList.add(addres1User2);
        addressNormalUserList.add(address2User2);

        //creating normal user
        UserModel normalUser1 = new UserModel(
            2,            
            "bob",  
            "esponja", 
            "garythebestpet@hotmail.com", 
            "123456789",
            rolNormalUserList,       
            addressNormalUserList  
        );
        
        //add normal and admin user to list.
        users.add(adminUser);
        users.add(normalUser1);
    }

    //Get Method that return a list of UserModel objects created by: IGNACIO EDUARDO RIQUELME ERAZO.
    @GetMapping("/getUsersInfo")
    public List<UserModel>getUsersInfo(){ 
        return this.users;
    }
    
    //Get Method that return a UserModel object, looking inside the userlist for id created by: IGNACIO EDUARDO RIQUELME ERAZO.
    @GetMapping("/getUsersInfo/{id}")
    public UserModel getUserById(@PathVariable int id){
        for (UserModel user : users)
        {
            //validating user id between 0 and 100 adn id inside the list.
            if(user.getId() >=0 &&  user.getId() == id)
            {
                return user;
            }
        }
        // return null if id user was not inside the list of users.
        return null;
    }
    
}
