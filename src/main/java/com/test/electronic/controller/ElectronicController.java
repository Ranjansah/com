package com.test.electronic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.electronic.electronics.Electronics;
import com.test.electronic.exception.UserNotFoundException;
import com.test.electronic.repository.ElectronicRepository;
import com.test.electronic.service.ElectronicService;

@RestController
public class ElectronicController {
	
	@Autowired
	private ElectronicService eleservice;

	
	@RequestMapping("/device")
	public List<Electronics> getAllDevices()
	{
		List<Electronics> ele =eleservice.getAllDevices();
		
		if(ele.size()<=0)
			throw new UserNotFoundException("Sorry Devices are not Present");
		return ele;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/device")
	public void addUniversity(@RequestBody Electronics customer)
	{
		eleservice.addCustomer(customer);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/device/{id}")
	public void UpdateUniversity(@PathVariable Integer id ,@RequestBody Electronics ele)
	{
		eleservice.addDevice(ele);
	}
	
	@GetMapping("/device/{name}")
	public List<Electronics> findDeviceWithName(@PathVariable String name)
	{
		List<Electronics> all=eleservice.findDeviceWithName(name);
		return all;
	}
	@GetMapping("/{price}")
	public List<Electronics> findDeviceWithPrice(@PathVariable String price)
	{
		List<Electronics> allp=eleservice.findDeviceWithName(price);
		return allp;
	}
	/*@RequestMapping(method=RequestMethod.DELETE,value="/device/{id}")
	public void UpdateDevice(@PathVariable Integer id )
	{
		eleservice.deleteDevice(id);
	}
		@GetMapping("/device/{id}")
	public Electronics getDevice(@PathVariable Integer id)
	{
		Electronics ele=eleservice.getDevice(id);
		
		if(ele==null)
			
			throw new UserNotFoundException("Id is not present");
		return ele;
	} */
	
}