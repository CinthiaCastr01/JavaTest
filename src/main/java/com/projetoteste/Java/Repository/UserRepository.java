package com.projetoteste.Java.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoteste.Java.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findAllByUserNameContainingIgnoreCase(String userName);

}
