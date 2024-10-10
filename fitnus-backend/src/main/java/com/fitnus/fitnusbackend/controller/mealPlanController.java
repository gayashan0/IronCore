package com.fitnus.fitnusbackend.controller;

import com.fitnus.fitnusbackend.exception.mealPlanNotFoundException;
import com.fitnus.fitnusbackend.model.mealPlanModel;
import com.fitnus.fitnusbackend.repository.mealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class mealPlanController {
    @Autowired
    private mealPlanRepository mealPlanRepository;
    @PostMapping("/meelplan")
    mealPlanModel newmeelModel(@RequestBody mealPlanModel newworkoutPlanModel){
        return mealPlanRepository.save(newworkoutPlanModel);
    }
    @GetMapping("/meelplan")
        List<mealPlanModel> getAllWorkout(){
            return mealPlanRepository.findAll();
    }
    @GetMapping("/meelplan/{id}")
    mealPlanModel getmeelplanId(@PathVariable Long id){
        return mealPlanRepository.findById(id)
                .orElseThrow(()->new mealPlanNotFoundException(id));
    }
    @PutMapping("/meelplan/{id}")
    mealPlanModel updatemeelplan(@RequestBody mealPlanModel newMealPlanModel, @PathVariable Long id) {
        return mealPlanRepository.findById(id)
                .map(mealPlanModel -> {
                    mealPlanModel.setName(newMealPlanModel.getName());
                    mealPlanModel.setRecipe(newMealPlanModel.getRecipe());
                    mealPlanModel.setInfo(newMealPlanModel.getInfo());
                    mealPlanModel.setDate(newMealPlanModel.getDate());
                    mealPlanModel.setSize(newMealPlanModel.getSize());
                    return mealPlanRepository.save(mealPlanModel);
                }).orElseThrow(() -> new mealPlanNotFoundException(id));
    }

    @DeleteMapping("/meelplan/{id}")
    String deletemeelplan(@PathVariable Long id){
        if (!mealPlanRepository.existsById(id)){
            throw new mealPlanNotFoundException(id);
        }
        mealPlanRepository.deleteById(id);
        return "WorkoutPlan with id "+id+ " Deleted ";
    }
}
