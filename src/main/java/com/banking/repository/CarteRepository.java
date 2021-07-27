package com.banking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.entities.*;



@Repository
public interface CarteRepository extends CrudRepository<Carte,Long>{

}
