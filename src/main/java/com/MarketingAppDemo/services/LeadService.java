package com.MarketingAppDemo.services;

import java.util.List;

import com.MarketingAppDemo.entity.Lead;

public interface LeadService {
	public void saveLead(Lead le);
	public List<Lead> getLeads();
	public void deleteOneLead(long id);
	public Lead findOneLead(long id);

}
