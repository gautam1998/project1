package com.stockmarket.company.service;

import java.util.Optional;

import com.stockmarket.company.model.IpoDetail;
import com.stockmarket.company.shared.IpoRequest;

public interface IpoService {
	
	public Iterable<IpoDetail> findAllIpos();
	public Optional<IpoDetail> findIpoById(Integer ipoId);
	public Iterable<IpoDetail> findIpoByCompanyId(Integer companyId);
	public Iterable<IpoDetail> findIpoByExchange(String exchange);
	public IpoDetail addIpo(IpoRequest ipo);
}
