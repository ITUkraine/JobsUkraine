package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
