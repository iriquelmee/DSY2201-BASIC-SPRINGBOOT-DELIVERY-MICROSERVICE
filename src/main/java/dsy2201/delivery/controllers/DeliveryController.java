package dsy2201.delivery.controllers;

import dsy2201.delivery.models.*;
import dsy2201.delivery.services.UserModelService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;


//Endpoint - Class Controller Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    //usermodel service Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
    @Autowired
    private UserModelService userService;
    
    //get individual user Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    //get all users Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
    @GetMapping
    public List<UserModel>getUsers() {
        return userService.getAllUsers();
    }

    //post individual user Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
    @PostMapping
    public ResponseEntity<UserModel> postUser(@RequestBody UserModel user) {
        try 
        {
            UserModel newUser = userService.postUser(user);
            if (newUser != null) 
            { 
                return new ResponseEntity<>(newUser, HttpStatus.OK);
            } 
            else 
            {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //update individual user Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> putUser(@PathVariable int id, @RequestBody UserModel user) {
        try 
        {
            UserModel updatedUser = userService.putUser(id, user);
            
            if (updatedUser != null) 
            {
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } 
            else 
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete individual user and data asociated Created and mantained by: IGNACIO EDUARDO RIQUELME ERAZO.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        try 
        {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
