package com.fitnus.fitnusbackend.repository;

import com.fitnus.fitnusbackend.model.WorkoutPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface workoutPlanRepository extends JpaRepository<WorkoutPlanModel,Long> {

}
