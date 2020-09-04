package com.stockmarket.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.company.model.IpoDetail;
import com.stockmarket.company.service.IpoService;
import com.stockmarket.company.shared.IpoRequest;

@RestController
@RequestMapping("/api")
public class IpoController {

	private IpoService ipoService;

	
	public IpoController(IpoService ipoService) {
		super();
		this.ipoService = ipoService;
	}
	
	@GetMapping("/ipos")
	public ResponseEntity<Iterable<IpoDetail>> findAllIpos(){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(ipoService.findAllIpos());
	}
	
	@GetMapping("/ipos/company_id/{companyId}")
	public ResponseEntity<Iterable<IpoDetail>> findByCompanyId(@PathVariable Integer companyId){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(ipoService.findIpoByCompanyId(companyId));
	}
	
	@GetMapping("/ipos/exchange/{exchange}")
	public ResponseEntity<Iterable<IpoDetail>> findByExchange(@PathVariable String exchange){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(ipoService.findIpoByExchange(exchange));
	}
	
	@PostMapping("/ipos")
	public ResponseEntity<IpoDetail> addNewIpo(@RequestBody IpoRequest ipoRequest){		
		
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(ipoService.addIpo(ipoRequest));
	}
}
