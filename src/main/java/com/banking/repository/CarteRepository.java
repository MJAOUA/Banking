package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.entities.*;



@Repository
public interface CarteRepository extends CrudRepository<Carte,Long>{

	@Query("Select c from Carte c where c.compte.user.id=:id")
	List<Carte> RetrieveActiveUserCartes(@Param("id")Long id);
	
}
