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
        
        //roles normal user 1.
        List<RolUserModel> rolNormalUserList = new ArrayList<>();
        RolUserModel          role1User2= new RolUserModel(2, "NORMAL");

        //addresess normal user 1.
        List<AddressUserModel> addressNormalUserList = new ArrayList<>();
        AddressUserModel    addres1User2= new AddressUserModel(1, "fondo de bikini 24");
        AddressUserModel    address2User2= new AddressUserModel(2, "crustaceo cascarudo 1, fondo de bikini");

        //creating normal user 1: adding 1 rol and 2 addresses.
        rolNormalUserList.add(role1User2);
        addressNormalUserList.add(addres1User2);
        addressNormalUserList.add(address2User2);

        //creating normal user 1.
        UserModel normalUser1 = new UserModel(
            2,            
            "bob",  
            "esponja", 
            "garythebestpet@hotmail.com", 
            "123456789",
            rolNormalUserList,       
            addressNormalUserList  
        );

        //roles normal user 2.
        List<RolUserModel> rolNormalUserList3 = new ArrayList<>();
        RolUserModel          role1User3= new RolUserModel(2, "NORMAL");

        //addresess normal user 2.
        List<AddressUserModel> addressNormalUserList3 = new ArrayList<>();
        AddressUserModel    addres1User3= new AddressUserModel(1, "fondo de bikini 25");

        //creating normal user 2: adding 1 rol and 2 addresses.
        rolNormalUserList3.add(role1User3);
        addressNormalUserList3.add(addres1User3);

        //creating normal user 2.
        UserModel normalUser2 = new UserModel(
            3,            
            "patricio",  
            "estrella", 
            "patrickostasr24@hotmail.com", 
            "987654321",
            rolNormalUserList3,       
            addressNormalUserList3  
        );

        //roles normal user 4.
        List<RolUserModel> rolNormalUserList4 = new ArrayList<>();
        RolUserModel          role1User4= new RolUserModel(2, "NORMAL");

        //addresess normal user 4.
        List<AddressUserModel> addressNormalUserList4 = new ArrayList<>();
        AddressUserModel    addres1User4= new AddressUserModel(1, "fondo de bikini 23");

        //creating normal user 4: adding 1 rol and 1 addresses.
        rolNormalUserList4.add(role1User4);
        addressNormalUserList4.add(addres1User4);

        //creating normal user 4.
        UserModel normalUser4 = new UserModel(
            4,            
            "calamardo",  
            "", 
            "pcalamardo28@hotmail.com", 
            "648532198",
            rolNormalUserList4,       
            addressNormalUserList4  
        );
                //
        //roles normal user 5.
        List<RolUserModel> rolNormalUserList5 = new ArrayList<>();
        RolUserModel          role1User5= new RolUserModel(2, "NORMAL");

        //addresess normal user 5.
        List<AddressUserModel> addressNormalUserList5 = new ArrayList<>();
        AddressUserModel    addres1User5= new AddressUserModel(1, "fondo de bikini 245");

        //creating normal user 5: adding 1 rol and 1 addresses.
        rolNormalUserList5.add(role1User4);
        addressNormalUserList5.add(addres1User4);

        //creating normal user 5.
        UserModel normalUser5 = new UserModel(
            5,            
            "don cangrejo",  
            "", 
            "dcangrejo999@hotmail.com", 
            "357951268",
            rolNormalUserList5,       
            addressNormalUserList5  
        );
        
        //roles normal user 6.
        List<RolUserModel> rolNormalUserList6 = new ArrayList<>();
        RolUserModel          role1User6= new RolUserModel(2, "NORMAL");

        //addresess normal user 6.
        List<AddressUserModel> addressNormalUserList6 = new ArrayList<>();
        AddressUserModel    addres1User6= new AddressUserModel(1, "fondo de bikini 654");

        //creating normal user 6: adding 1 rol and 1 addresses.
        rolNormalUserList5.add(role1User6);
        addressNormalUserList5.add(addres1User6);

        //creating normal user 6.
        UserModel normalUser6 = new UserModel(
            6,            
            "plancton",  
            "", 
            "cagreburgertopsecret@hotmail.com", 
            "321456951",
            rolNormalUserList6,       
            addressNormalUserList6  
        );
                
        //add 6 users only admin has admin rol.
        users.add(adminUser);
        users.add(normalUser1);
        users.add(normalUser2);
        users.add(normalUser4);
        users.add(normalUser5);
        users.add(normalUser6);
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
