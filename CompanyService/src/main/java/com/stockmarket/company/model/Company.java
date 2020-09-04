package com.stockmarket.company.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id",nullable = false)
	private Integer companyId;
	
	@Column(name = "company_name",nullable = false)
	private String companyName;
	
	@Column(name = "turnover")
	private Long turnover;

	@Column(name = "ceo")
	private String ceo;
	
	@Column(name = "writeup")
	private String writeup;
	
	@Column(name = "company_code")
	private String companyCode;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinTable(name = "company_listing",
		joinColumns = @JoinColumn(name="id"),
		inverseJoinColumns = @JoinColumn(name= "company_id"))
	private List<Exchange> exchanges;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", nullable = true)
	private List<Director> directors;
	
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "company_id",nullable = true)
	private List<IpoDetail> ipoDetails;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getTurnover() {
		return turnover;
	}

	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getWriteup() {
		return writeup;
	}

	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public List<Exchange> getExchanges() {
		return exchanges;
	}

	public void setExchanges(List<Exchange> exchanges) {
		this.exchanges = exchanges;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<IpoDetail> getIpoDetails() {
		return ipoDetails;
	}

	public void setIpoDetails(List<IpoDetail> ipoDetails) {
		this.ipoDetails = ipoDetails;
	}

	public Company(Integer companyId, String companyName, Long turnover, String ceo, String writeup, String companyCode,
			List<Exchange> exchanges, List<Director> directors, List<IpoDetail> ipoDetails) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.writeup = writeup;
		this.companyCode = companyCode;
		this.exchanges = exchanges;
		this.directors = directors;
		this.ipoDetails = ipoDetails;
	}

	public Company() {
		super();
	}
	
	
	
}