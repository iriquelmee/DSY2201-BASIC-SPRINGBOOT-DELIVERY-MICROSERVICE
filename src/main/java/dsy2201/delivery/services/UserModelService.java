package dsy2201.delivery.services;

import dsy2201.delivery.models.AddressUserModel;
import dsy2201.delivery.models.UserModel;
import dsy2201.delivery.repository.AddressModelRepository;
import dsy2201.delivery.repository.UserModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserModelService implements IUserModelService {

    @Autowired
    private UserModelRepository userRepository;

    @Autowired
    private AddressModelRepository addressRepository; 

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserById(int id) {
        return userRepository.findById(id);
    }
    
    @Override
    @Transactional
    public UserModel postUser(UserModel user) {
        // Save the user to get the generated ID
        UserModel savedUser = userRepository.save(user);
        
        // Set the user for each AddressUserModel in the addresses list
        if(user.getAddresses() != null) {
            for(AddressUserModel address : user.getAddresses()) {
                address.setUser(savedUser);
                addressRepository.save(address);
            }
        }
        
        return savedUser;
    }

    @Override
    @Transactional
    public UserModel putUser(int id, UserModel user) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        
        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();
            
            // Update the existing user fields
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setMail(user.getMail());
            existingUser.setPhoneContact(user.getPhoneContact());
            existingUser.setRoles(user.getRoles()); // Update roles if needed
            existingUser.setAddresses(user.getAddresses()); // Update addresses if needed
            
            // Save the updated user
            UserModel updatedUser = userRepository.save(existingUser);
            
            // Update addresses if needed
            if (user.getAddresses() != null) {
                for (AddressUserModel address : user.getAddresses()) {
                    address.setUser(updatedUser);
                    addressRepository.save(address);
                }
            }
            
            return updatedUser;
        } else {
            return null; // Return null if user with given ID doesn't exist
        }
    }
    
    @Override
    @Transactional
    public void deleteUser(int id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            
            // Delete addresses associated with the user
            if (user.getAddresses() != null) {
                for (AddressUserModel address : user.getAddresses()) {
                    addressRepository.delete(address);
                }
            }
            
            // Delete the user
            userRepository.deleteById(id);
        }
    }    
    
}
