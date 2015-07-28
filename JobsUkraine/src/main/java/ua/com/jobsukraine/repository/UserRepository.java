package ua.com.jobsukraine.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
