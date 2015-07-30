package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}