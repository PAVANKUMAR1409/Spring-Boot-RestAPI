package com.pk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.entity.Tourist;
import com.pk.exception.TouristNotFoundExcpetion;
import com.pk.repository.ITouristRepository;



@Service
public class TouristmMgmtServiceImpl implements ITouristService {

	@Autowired
	private ITouristRepository touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		Tourist save = touristRepo.save(tourist);
		Integer idVal=save.getTid();
		return "Tourist is saved with id value :: "+idVal;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	
	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundExcpetion {
		
		return touristRepo.findById(tid).orElseThrow(()->new TouristNotFoundExcpetion(tid+" tourist not found"));
		
	}
	
	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundExcpetion {
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if(optional.isPresent()) {
			touristRepo.save(tourist);   // save can perform both insert and update operation
			return tourist.getTid()+"  Tourist is updated";
		}
		else {
			throw new TouristNotFoundExcpetion(tourist.getTid()+" tourist is not found");
		}
	}
	
	@Override
	public String updateTouristBudgetById(Integer tid, Double hikePercentage) throws TouristNotFoundExcpetion {
		//get tourist by id
		Optional<Tourist> opt = touristRepo.findById(tid);
		if(opt.isPresent()) {
			//get existing budget of the tourist id
			Tourist tourist = opt.get();
			Double budget = tourist.getBudget();
			Double newBudget=budget+(budget*hikePercentage/100.0);
			// update tourist with new budget\
			tourist.setBudget(newBudget);
			touristRepo.save(tourist);
			return "Tourist Budget get hiked with "+hikePercentage+"  and the new budget is :"+newBudget;
		}else {
			throw new TouristNotFoundExcpetion(tid+" tid tourist not found for updation");
		}
		
		
		
	}
	
	@Override
	public String removeTouristById(Integer tid) throws TouristNotFoundExcpetion {
		//get tourist by id
		Optional<Tourist> opt = touristRepo.findById(tid);
		if(opt.isPresent()) {
			touristRepo.deleteById(tid);
			return tid+" tid is found and deleted";
		}else {
			throw new TouristNotFoundExcpetion(tid+" tid is not found for deletion");
		}
		
	}
	
}
