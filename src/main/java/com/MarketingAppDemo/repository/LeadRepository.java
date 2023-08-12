package com.MarketingAppDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketingAppDemo.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
