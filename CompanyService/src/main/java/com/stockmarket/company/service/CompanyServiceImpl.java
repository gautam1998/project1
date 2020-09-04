package com.stockmarket.company.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.stockmarket.company.dao.CompanyDao;
import com.stockmarket.company.model.Company;
import com.stockmarket.company.shared.CompanyResponse;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyDao companyDao;
	private ModelMapper modelMapper;
	public CompanyServiceImpl(CompanyDao companyDao, ModelMapper modelMapper) {
		super();
		this.companyDao = companyDao;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public Company addNewCompany(Company company) {
		return companyDao.save(company);
	}

	@Override
	@Transactional
	public Iterable<CompanyResponse> findAllCompany() {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<CompanyResponse>> () {}.getType();
		List<CompanyResponse> companyResponse = modelMapper.map(companyDao.findAll(), listType);
		return companyResponse;
	}
	@Override
	public CompanyResponse findByCompanyId(Integer companyId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type obj = new TypeToken<CompanyResponse> () {} .getType();
		CompanyResponse companyResponse;
		try {
			companyResponse = modelMapper.map(companyDao.findById(companyId).get(), obj);
		} catch (NoSuchElementException e) {
			companyResponse = null;
		}
		return companyResponse;
	}

	@Override
	public CompanyResponse findByCompanyName(String companyName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type obj = new TypeToken<CompanyResponse> () {} .getType();
		CompanyResponse companyResponse;
		try {
			companyResponse = modelMapper.map(companyDao.findByName(companyName).get(), obj);
		} catch (NoSuchElementException e) {
			companyResponse = null;
		}
		return companyResponse;
	}

	@Override
	public Company updateComanyByName(Company company, String companyName) {
		// TODO Auto-generated method stub
		
		Company temp = companyDao.findByName(companyName).orElse(null);
		
		if(temp == null) {
        	System.out.println("null");
        }
        if (company.getCompanyCode().length() != 0) {
        	System.out.println('1');
            temp.setCompanyCode(company.getCompanyCode());
        }
        if (company.getCompanyId() != null) {
        	System.out.println('1');
            temp.setCompanyId(company.getCompanyId());
        }
        if (company.getCompanyName().length() != 0) {
        	System.out.println('1');
            temp.setCompanyName(company.getCompanyName());
        }
        if (company.getDirectors() != null) {
        	System.out.println('1');
            temp.setDirectors(company.getDirectors());
        }
        if (company.getExchanges() != null) {
        	System.out.println('1');
            temp.setExchanges(company.getExchanges());
        }
        if (company.getIpoDetails()!=null) {
        	System.out.println('1');
            temp.setIpoDetails(company.getIpoDetails());
        }
        if (company.getTurnover() != null) {
        	System.out.println('1');
            temp.setTurnover(company.getTurnover());
        }
        if (company.getWriteup() != null) {
        	System.out.println('1');
            temp.setWriteup(company.getWriteup());
        }
        System.out.println(temp.getCompanyName());
        companyDao.saveAndFlush(temp);
        return temp;
        
        
	}
	
		
	
}
