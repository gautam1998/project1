package com.stockmarket.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmarket.company.model.Director;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer>{

}
