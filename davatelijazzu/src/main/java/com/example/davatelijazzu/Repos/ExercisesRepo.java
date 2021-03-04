package com.example.davatelijazzu.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.davatelijazzu.entity.Exercises;


public interface ExercisesRepo extends JpaRepository<Exercises, Long>{
	
	public List<Exercises> findAll();
	
	public Exercises findById(int id);
	
	public Exercises deletedById(int id);

}
