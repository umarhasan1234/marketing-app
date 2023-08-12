package com.MarketingAppDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MarketingAppDemo.entity.Lead;
import com.MarketingAppDemo.services.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadService leadService;
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadService.getLeads();
		return leads;
	}
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadService.saveLead(lead);
		
	}
	@PutMapping
	public void updateLeadData(@RequestBody Lead lead) {
		leadService.saveLead(lead);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLeadData(@PathVariable("id") long id) {
		leadService.deleteOneLead(id);	
	}
	
	@RequestMapping("/get/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		try {
			Lead lead = leadService.findOneLead(id);
			return lead;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

