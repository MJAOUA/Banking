package com.banking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.entities.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query("Select c from User c where c.username=:username")
	User RetrieveUserInfo(@Param("username")String username);
	
	
	@Query("Select c from User c where c.profession not like 'Admin' ")
	List<User> RetrieveClients();
	

}
