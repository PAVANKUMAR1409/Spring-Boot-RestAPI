package com.pk.service;

import java.util.List;

import com.pk.entity.Tourist;
import com.pk.exception.TouristNotFoundExcpetion;

public interface ITouristService {

		public String registerTourist(Tourist tourist );
		
		public List<Tourist> fetchAllTourist();
		
		public Tourist fetchTouristById(Integer tid)throws TouristNotFoundExcpetion;
		
		public String updateTouristDetails(Tourist tourist)throws TouristNotFoundExcpetion;
		
		public String updateTouristBudgetById(Integer tid, Double hikePercentage)throws TouristNotFoundExcpetion;
		
		public String removeTouristById(Integer tid)throws TouristNotFoundExcpetion;
		
}
