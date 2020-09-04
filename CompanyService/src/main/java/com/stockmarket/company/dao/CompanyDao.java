	package com.stockmarket.company.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.company.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{
	@Query(value="select * from company c where c.company_name = ?1", nativeQuery = true)
	public Optional<Company> findByName(String companyName);
 }
