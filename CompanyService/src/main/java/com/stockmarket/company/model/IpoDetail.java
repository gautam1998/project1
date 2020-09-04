package com.stockmarket.company.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ipo_detail")
public class IpoDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ipo_id")
	private Integer ipoId;
	
	@Column(name = "exchange")
	private String exchange;
	
	@Column(name = "share_price")
	private double sharePrice;
	
	@Column(name = "number_of_shares")
	private double numberOfShares;
	
	@Column(name = "open_time")
	private Timestamp openTime;

	public IpoDetail(String exchange, double sharePrice, double numberOfShares, Timestamp openTime) {
		super();
		//this.ipoId = ipoId;
		this.exchange = exchange;
		this.sharePrice = sharePrice;
		this.numberOfShares = numberOfShares;
		this.openTime = openTime;
	}

	public IpoDetail() {
		super();
	}

	public Integer getIpoId() {
		return ipoId;
	}

	public void setIpoId(Integer ipoId) {
		this.ipoId = ipoId;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public double getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(double numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public Timestamp getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}
	
	
	
}
