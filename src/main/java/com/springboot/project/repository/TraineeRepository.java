package com.springboot.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.project.model.Trainee;
@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long>
{
	
  
}
