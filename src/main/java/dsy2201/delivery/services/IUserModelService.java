package dsy2201.delivery.services;
import java.util.List;
import java.util.Optional;
import dsy2201.delivery.models.UserModel;

public interface IUserModelService {
    
    List<UserModel>getAllUsers();
    Optional<UserModel>getUserById(int id);
    UserModel postUser(UserModel movie);
    UserModel putUser(int id, UserModel movie);
    void deleteUser(int id);
}
