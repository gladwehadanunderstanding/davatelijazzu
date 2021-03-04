package com.example.davatelijazzu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.davatelijazzu.Repos.ExercisesRepo;
import com.example.davatelijazzu.entity.Exercises;



@Controller
@RequestMapping("/exercises")
public class ExerciseController {

	@Autowired
	private ExercisesRepo exercisesRepo;
	
	@GetMapping
	public String getListEmployees(Model model) {
		List<Exercises> exercisesList = exercisesRepo.findAll();
		
		model.addAttribute("exercises", exercisesList);
		return "exercises-list";
	}
	
	@GetMapping("/addExercises")
	public String addExercises(Model model) {
		
		Exercises exercises = new Exercises();
		
		model.addAttribute("exercises",exercises);
		
		return "exercises-add";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("exercises") Exercises exercises) {
		exercisesRepo.save(exercises);
		
		return "redirect:/exercises-list";
	}
	
}
