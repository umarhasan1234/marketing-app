package com.MarketingAppDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarketingAppDemo.entity.Lead;
import com.MarketingAppDemo.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadrepo;
	@Override
	public void saveLead(Lead le) {
		leadrepo.save(le);
		
	}
	@Override
	public List<Lead> getLeads() {
		List<Lead> leads=leadrepo.findAll();
		return leads;
	}
	@Override
	public void deleteOneLead(long id) {
		leadrepo.deleteById(id);
	}
	@Override
	public Lead findOneLead(long id) {
		Optional<Lead>findById=leadrepo.findById(id);
		Lead lead=findById.get();
		return lead;
	}
	

}
