package com.example.Bandproject.repositories;

import com.example.Bandproject.models.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Repository extends CrudRepository<User, Integer> {


}