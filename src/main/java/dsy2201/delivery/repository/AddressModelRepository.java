package dsy2201.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dsy2201.delivery.models.AddressUserModel;

public interface AddressModelRepository extends JpaRepository<AddressUserModel,Integer>{
    
}
