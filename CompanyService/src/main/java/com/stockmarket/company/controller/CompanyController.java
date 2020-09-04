package com.stockmarket.company.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.company.exception.CompanyNotFoundException;
import com.stockmarket.company.model.Company;
import com.stockmarket.company.service.CompanyService;
import com.stockmarket.company.shared.CompanyResponse;

@RestController
@RequestMapping("/api")
public class CompanyController {
	
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping("/company")
	public ResponseEntity<Iterable<CompanyResponse>> findAllCompany()
	{
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(companyService.findAllCompany());
				
	}
	
	@PostMapping("/company")
	public ResponseEntity<Company> addNewCompany(@RequestBody Company company)
	{
		company.setCompanyCode(UUID.randomUUID().toString());
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(companyService.addNewCompany(company));
	}
	
	@GetMapping("/company/id/{companyId}")
	public ResponseEntity<CompanyResponse> findCompanyById(@PathVariable Integer companyId) throws CompanyNotFoundException
	{
		CompanyResponse cr = companyService.findByCompanyId(companyId);
		
		if (cr == null)
		{
			throw new CompanyNotFoundException("Company not found with id "+ companyId);
		}
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(cr);
	}
	
	@GetMapping("/company/name/{companyName}")
	public ResponseEntity<CompanyResponse> findByCompanyName(@PathVariable String companyName) throws CompanyNotFoundException
	{
		CompanyResponse cr = companyService.findByCompanyName(companyName);
		
		if (cr == null)
		{
			throw new CompanyNotFoundException("Company not found with name "+ companyName);
		}
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(cr);
	}
	
	
	@PostMapping("/updateInfo/{companyId}")
    public ResponseEntity<Company> updateCompanyInfo(@RequestBody Company companyDTO, @PathVariable String companyId) {
        Company companyDTO1 = companyService.updateComanyByName(companyDTO, companyId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyDTO1);
    }

}
