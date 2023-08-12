package com.MarketingAppDemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MarketingAppDemo.dto.LeadData;
import com.MarketingAppDemo.entity.Lead;
import com.MarketingAppDemo.services.LeadService;
import com.MarketingAppDemo.utilities.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;
	
	
	@RequestMapping("/viewCreateLeadPage")
	public String viewCreateLeadPage() {
		return "create_lead";
	}   
	
	@RequestMapping("/saveLead")
	public String saveOneLeadData(@ModelAttribute("abcd") Lead le, ModelMap model) {
		leadService.saveLead(le);
		emailService.sendEmail(le.getEmail(), "Welcome", "We have received inquiry");
		 model.addAttribute("msg","Lead data is saved");
		return "create_lead";
	}

	
	
//	@RequestMapping("/saveLead")
//	public String saveOneLeadData(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email, @RequestParam("mobile") String mobile) {
//		Lead l=new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		return "create_lead";
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLeadData(LeadData ld, ModelMap model) {
//		Lead l=new Lead();
//		l.setFirstName(ld.getFirstName());
//		l.setLastName(ld.getLastName());
//		l.setEmail(ld.getEmail());
//		l.setMobile(ld.getMobile());
//		model.addAttribute("msg","All data is saved ");
//		leadService.saveLead(l);
//		
//		return "create_lead";
//	}
	
	
	@RequestMapping("/listall")
	public String getAllLeads(ModelMap model) {
		List<Lead> leads=leadService.getLeads();
		model.addAttribute("leads",leads);
		return "lead_data_result";
		
	}
	
	@RequestMapping("/delete")
	public String deleteLeadData(@RequestParam("id") long id, ModelMap model) {
		leadService.deleteOneLead(id);
		List<Lead> leads=leadService.getLeads();
		model.addAttribute("leads",leads);
		return "lead_data_result";
	}
	@RequestMapping("/update")
	public String updateLeadData(@RequestParam("id") long id, ModelMap model) {
		Lead leads=leadService.findOneLead(id);
		model.addAttribute("leads",leads);
		return "lead_data_result";
	}
	
	
	
	
}
