package com.uiktp.finki.ukim.fluidlearning.Repository;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
