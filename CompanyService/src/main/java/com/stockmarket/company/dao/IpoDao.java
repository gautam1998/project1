package com.stockmarket.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.company.model.IpoDetail;

@Repository
public interface IpoDao extends JpaRepository<IpoDetail, Integer>{

	@Query(value = "select * from ipo_detail d where d.exchange = ?1", nativeQuery = true)
	public Iterable<IpoDetail> findByExchange(String exchange);
	@Query(value = "select * from ipo_detail d where d.company_id = ?1", nativeQuery = true)
	public Iterable<IpoDetail> findbyCompanyName(Integer companyId);
	
	@Modifying
	@Query(value = "update ipo_detail d set d.company_id = ?1 where d.ipo_id = ?2",nativeQuery = true)
	public void addForeignKey(Integer companyId, Integer ipoId);

}
