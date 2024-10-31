package com.m1_fonda.service_users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.m1_fonda.service_users.models.Userbanque;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<Userbanque , Integer>{
    
}
