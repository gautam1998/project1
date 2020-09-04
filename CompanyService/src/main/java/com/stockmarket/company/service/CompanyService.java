package com.stockmarket.company.service;

import com.stockmarket.company.model.Company;
import com.stockmarket.company.shared.CompanyResponse;

public interface CompanyService {
	public Company addNewCompany(Company company);
	public Iterable<CompanyResponse> findAllCompany();
	public CompanyResponse findByCompanyId(Integer companyId);
	public CompanyResponse findByCompanyName(String companyName);
	public Company updateComanyByName(Company company,String companyName);
}
