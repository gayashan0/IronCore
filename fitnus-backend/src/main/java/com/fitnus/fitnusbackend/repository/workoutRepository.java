package com.fitnus.fitnusbackend.repository;

import com.fitnus.fitnusbackend.model.WorkoutModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface workoutRepository extends JpaRepository<WorkoutModel,Long> {

}
