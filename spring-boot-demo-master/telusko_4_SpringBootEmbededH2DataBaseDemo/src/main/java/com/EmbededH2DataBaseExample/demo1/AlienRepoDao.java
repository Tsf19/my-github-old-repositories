package com.EmbededH2DataBaseExample.demo1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.EmbededH2DataBaseExample.model2.Alien;

//7. extends CrudRepository
public interface AlienRepoDao extends CrudRepository<Alien, Integer> {



}