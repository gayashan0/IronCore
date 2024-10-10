package com.fitnus.fitnusbackend.controller;

import com.fitnus.fitnusbackend.exception.WorkoutNotFoundException;
import com.fitnus.fitnusbackend.model.WorkoutModel;
import com.fitnus.fitnusbackend.repository.workoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class workoutController {
    @Autowired
    private workoutRepository workoutRepository;
    @PostMapping("/workout")
    WorkoutModel newworkoutModel(@RequestBody WorkoutModel newworkoutModel){
        return workoutRepository.save(newworkoutModel);
    }
    @GetMapping("/workout")
        List<WorkoutModel> getAllWorkout(){
            return workoutRepository.findAll();
    }
    @GetMapping("/workout/{id}")
    WorkoutModel getWorkoutId(@PathVariable Long id){
        return workoutRepository.findById(id)
                .orElseThrow(()->new WorkoutNotFoundException(id));
    }
    @PutMapping("/workout/{id}")
    WorkoutModel updateworkout(@RequestBody WorkoutModel newWorkoutModel, @PathVariable Long id) {
        return workoutRepository.findById(id)
                .map(workoutModel -> {
                    workoutModel.setDate(newWorkoutModel.getDate());
                    workoutModel.setRun(newWorkoutModel.getRun());
                    workoutModel.setPushups(newWorkoutModel.getPushups());
                    workoutModel.setDescription(newWorkoutModel.getDescription());
                    workoutModel.setLifted(newWorkoutModel.getLifted());
                    return workoutRepository.save(workoutModel);
                }).orElseThrow(() -> new WorkoutNotFoundException(id));
    }

    @DeleteMapping("/workout/{id}")
    String deleteworkout(@PathVariable Long id){
        if (!workoutRepository.existsById(id)){
            throw new WorkoutNotFoundException(id);
        }
        workoutRepository.deleteById(id);
        return "Workout with id "+id+ " Deleted ";
    }
}
