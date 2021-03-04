package com.example.davatelijazzu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="topictable")
public class Exercises {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String exerciseName;
	private String exerciseMessage;
	private String exerciseDescribe;
	private String exercieseTag;
	
	public Exercises() {}
	
	public Exercises(String exerciseName, String exerciseMessage) {
		this.exerciseName = exerciseName;
		this.exerciseMessage = exerciseMessage;
	}
	
	public Exercises(String exerciseName, String exerciseMessage, String exerciseDescribe) {
		this.exerciseName = exerciseName;
		this.exerciseMessage = exerciseMessage;
		this.exerciseDescribe = exerciseDescribe;
	}
	
	
	public String getExercieseTag() {
		return exercieseTag;
	}

	public void setTopicTag(String exercieseTag) {
		this.exercieseTag = exercieseTag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getExerciseMessage() {
		return exerciseMessage;
	}

	public void setExerciseMessage(String exerciseMessage) {
		this.exerciseMessage = exerciseMessage;
	}

	public String getExerciseDescribe() {
		return exerciseDescribe;
	}

	public void setTopicDescribe(String exerciseDescribe) {
		this.exerciseDescribe = exerciseDescribe;
	}

}
