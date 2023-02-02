package com.springboot.project.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.model.Trainee;
import com.springboot.project.repository.TraineeRepository;

import java.util.*;

import javax.validation.ValidationException;

@RestController
@CrossOrigin
public class TraineeController 
{
   @Autowired
	private TraineeRepository traineeRepository;
	

	private static final Logger LOGGER =org.slf4j.LoggerFactory.getLogger(TraineeController.class);
	 @RequestMapping(value ="/traine")
	public List<Trainee> getAllTrainee()
	 {
		
			 LOGGER.info("inside class!!!! TraineeController,The getAllTrainee method is Begin");
			 LOGGER.debug("its for Debugging purpose");
			List<Trainee> list = traineeRepository.findAll();
			 
			   if(list!=null)
			   {
				   LOGGER.info("Get trainee Fetched succesfully...");
			   }
				 return list;	
	}
	@RequestMapping(value ="/traine" , method=RequestMethod.POST)
	public Map<String,Object>savetrainee( @RequestBody Trainee trainee)
	{   
		LOGGER.info("inside class!!!! TraineeController,The Save method is Begin");	 
		LOGGER.debug("its for Debugging purpose");
			try {
				Map<String,Object> apiResponse=new HashMap<String,Object>();
				
				apiResponse.put("StatusCode",HttpStatus.ACCEPTED.value());
				apiResponse.put("Data", traineeRepository.save(trainee));
				apiResponse.put("Message","Trainee Created Successfully...!");
				
				return apiResponse;
			}catch (ValidationException p)
			{
				// TODO: handle exception
              Map<String,Object> apiResponse=new HashMap<String,Object>();
				
				apiResponse.put("StatusCode",HttpStatus.BAD_REQUEST);
				apiResponse.put("Data", null);
				apiResponse.put("Message","inValid inputs...!");
				

				return apiResponse;
			}
			catch (Exception e)
			{
				// TODO: handle exception
				Map<String,Object> apiResponse=new HashMap<String,Object>();
				
				apiResponse.put("StatusCode",HttpStatus.BAD_REQUEST);
				apiResponse.put("Data", null);
				apiResponse.put("Message"," Invalid input please check careFully...!");
				

				return apiResponse;
			}
      
			
		
	}
    @PutMapping(value="/traine/{traineId}")
    public Map<String,Object>updatetrainee(@PathVariable("traineId") Long traineId, @RequestBody Trainee trainee)
     {
    	 Trainee existingtrainee=null;
    	try {
    		existingtrainee=traineeRepository.findById(traineId).get();
    		existingtrainee.setName(trainee.getName());	
			existingtrainee.setDateOfBirth(trainee.getDateOfBirth());
			existingtrainee.setMobileNumber(trainee.getMobileNumber());
			
 		    existingtrainee.getAddress().setDoor_no(trainee.getAddress().getDoor_no());;
			existingtrainee.getAddress().setStreet_name(trainee.getAddress().getStreet_name());
			existingtrainee.getAddress().setLand_mark(trainee.getAddress().getLand_mark());
			existingtrainee.getAddress().setPincode(trainee.getAddress().getPincode());
			existingtrainee.getAddress().setCity(trainee.getAddress().getCity());
    		existingtrainee.getAddress().setState(trainee.getAddress().getState());
	     	existingtrainee.getAddress().setCountry(trainee.getAddress().getCountry());
			  Trainee updated= traineeRepository.save(existingtrainee);
			  Map<String,Object> apiResponse=new HashMap<String,Object>();
				
				apiResponse.put("StatusCode",HttpStatus.ACCEPTED.value());
				apiResponse.put("Data", updated);
				apiResponse.put("Message","Trainee updated Successfully...!");
				if(apiResponse !=null)
				{
					LOGGER.info("Updated Succesfully..");
				}
				
				return apiResponse;	
		}
    	catch(ValidationException n)
		{
			// TODO: handle exception
          Map<String,Object> apiResponse=new HashMap<String,Object>();
			
			apiResponse.put("StatusCode",HttpStatus.FORBIDDEN.value());
			apiResponse.put("Data", null);
			apiResponse.put("Message","Not Updated...InValid inputs...!");
			

			return apiResponse;
		}
    	catch (Exception e) 
    	{
			// TODO: handle exception
           Map<String,Object> apiResponse=new HashMap<String,Object>();
			
			apiResponse.put("StatusCode",HttpStatus.FORBIDDEN.value());
			apiResponse.put("Data",null);
			apiResponse.put("Message","Not updated Invalid input kindly check careFully..!");
			return apiResponse;
		}
    	
    	
    }
   @DeleteMapping(value="/traine/{traineId}")
   public Map<String,Object>deleteTrinee(@PathVariable("traineId") Long traineeId)
   {
	     LOGGER.info("inside class!!!! TraineeController,The DeleteTrainee method is Begin");
		 LOGGER.debug("its for Debugging purpose"); 
		 
		 try {
			 traineeRepository.deleteById(traineeId);
			 LOGGER.info("Deleted succesfully..");
			 Map<String,Object> apiResponse=new HashMap<String,Object>();
				
				apiResponse.put("StatusCode",HttpStatus.OK.value());
				apiResponse.put("Data",null);
				apiResponse.put("Message","Trainee Deleted Successfully...!");
				return apiResponse;
		} catch (Exception e) 
		 {
          Map<String,Object> apiResponse=new HashMap<String,Object>();
			
			apiResponse.put("StatusCode",HttpStatus.NOT_FOUND.value());
			apiResponse.put("Data",null);
			apiResponse.put("Message","Invalid input Can't find Trainee with Id .... "+traineeId);
			return apiResponse;
		 }
   }
 
  @GetMapping(value="/traine/{traineId}")
  public Map< String,Object> getbyId(@PathVariable("traineId") Long traineId)
  {
	  LOGGER.info("inside method!!!!: getbyId,traineId");
	try {
		Trainee get=traineeRepository.findById(traineId).get();
		if(get !=null)
		{
			LOGGER.info("Fetched Succesfully..");
		}
		
		Map<String,Object> apiResponse=new HashMap<String,Object>();
		
		apiResponse.put("StatusCode",HttpStatus.ACCEPTED.value());
		apiResponse.put("Data",get);
		
		return apiResponse;
		  
	} catch (Exception e) {
		Map<String,Object> apiResponse=new HashMap<String,Object>();
		
		apiResponse.put("StatusCode",HttpStatus.NOT_FOUND.value());
		apiResponse.put("Data",null);
		apiResponse.put("Message"," Invalid input Can't find Trainee with Id "+traineId);
		return apiResponse;
		
	}
	  
  }
}
