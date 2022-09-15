package com.test.electronic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.electronic.electronics.Electronics;
import com.test.electronic.exception.UserNotFoundException;
import com.test.electronic.repository.ElectronicRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class ElectronicService {
	
	@Autowired
	public ElectronicRepository eleRepo;
	
	
	public List<Electronics> getAllDevices()
	{
		List<Electronics> eles=new ArrayList<>();
		eleRepo.findAll().forEach(eles::add);
		return  eles;
	}
	
	/*public Electronics getDevice(Integer id)
	{
		try
		{
			return eleRepo.findById(id).get();
		}
		catch(Exception e)
		{
			return null;
		}
	}*/
	
	public void addDevice(Electronics ele)
	{
				
		eleRepo.save(ele);
	}
	


	public void updateDevice(Integer id, Electronics ele)
	{
		eleRepo.save(ele);
	}
	
	public void deleteDevice(Integer id)
	{
		eleRepo.deleteById(id);
	}
	
	public List<Electronics> findDeviceWithName(String name)
	 {
	 try
	 {
		 return eleRepo.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.ASC,name));
	 }
	 catch(Exception e)
	 {
	 return null;
	 }
	}
	public List<Electronics> findDeviceWithPrice(String price)
	 {
	 try
	 {
		 return eleRepo.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.ASC,price));
	 }
	 catch(Exception e)
	 {
	 return null;
	 }
	}
}