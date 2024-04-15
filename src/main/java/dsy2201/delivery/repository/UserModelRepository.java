package dsy2201.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dsy2201.delivery.models.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel,Integer>{
    
}
