package com.avik.myplan.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avik.myplan.beans.Plan;

// This is a comment added by Avik

public class PlanDAO {
	
	public PlanDAO() {
		
	}
	
	public List<Plan> getAllPlans() {
		
		List<Plan> plans = new ArrayList<Plan>();
		
		return plans;
	}
	
	public Plan getPlanByName(String plan) {
		
		Plan myplan = new Plan();
		
		return myplan;
	}
	
	public List<Plan> getPlansByMonth(String month) {
		
		List<Plan> plans = new ArrayList<Plan>();
		
		return plans;
	}

}
