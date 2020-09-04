package com.stockmarket.company.service;

import java.lang.reflect.Type;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.stockmarket.company.dao.IpoDao;
import com.stockmarket.company.model.IpoDetail;
import com.stockmarket.company.shared.IpoRequest;

@Service
public class IpoServiceImpl implements IpoService{
	
	private IpoDao ipoDao;
	private ModelMapper modelMapper;

	public IpoServiceImpl(IpoDao ipoDao, ModelMapper modelMapper) {
		super();
		this.ipoDao = ipoDao;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public Iterable<IpoDetail> findAllIpos() {
		return ipoDao.findAll();
	}

	@Override
	@Transactional
	public Optional<IpoDetail> findIpoById(Integer ipoId) {
		return ipoDao.findById(ipoId);
	}

	@Override
	@Transactional
	public Iterable<IpoDetail> findIpoByCompanyId(Integer companyId) {
		return ipoDao.findbyCompanyName(companyId);
	}

	@Override
	@Transactional
	public Iterable<IpoDetail> findIpoByExchange(String exchange) {
		return ipoDao.findByExchange(exchange);
	}

	@Override
	@Transactional
	public IpoDetail addIpo(IpoRequest ipo) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type obj = new TypeToken<IpoDetail> () {}.getType();
		IpoDetail ipoDetail = modelMapper.map(ipo, obj);
		ipoDetail = ipoDao.save(ipoDetail);
		ipoDao.addForeignKey(ipo.getCompanyId(), ipoDetail.getIpoId());
		return ipoDetail;
	}	
}
