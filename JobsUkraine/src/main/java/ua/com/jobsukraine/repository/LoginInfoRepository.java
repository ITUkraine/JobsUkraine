package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.LoginInfo;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer>{

}
