package com.stockmarket.company.shared;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpoRequest {
	private Integer ipoId;
	
	private String exchange;
	
	private double sharePrice;

	private double numberOfShares;
	
	private Timestamp openTime;
	
	private Integer companyId;

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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public IpoRequest(Integer ipoId, String exchange, double sharePrice, double numberOfShares, Timestamp openTime,
			Integer companyId) {
		super();
		this.ipoId = ipoId;
		this.exchange = exchange;
		this.sharePrice = sharePrice;
		this.numberOfShares = numberOfShares;
		this.openTime = openTime;
		this.companyId = companyId;
	}

	public IpoRequest() {
		super();
	}
	
	
}
