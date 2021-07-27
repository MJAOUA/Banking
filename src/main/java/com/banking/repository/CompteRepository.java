package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.entities.*;

@Repository
public interface CompteRepository  extends CrudRepository<Compte,Long> {

	@Query("Select c from Compte c where c.user.id=:id")
	List<Compte> RetrieveActiveUserComptes(@Param("id")Long id);
	
}
