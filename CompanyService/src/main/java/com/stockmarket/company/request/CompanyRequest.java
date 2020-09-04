package com.stockmarket.company.request;

import lombok.Data;

import java.util.List;

import com.gautam.sm.models.StockExchange;
import com.gautam.sm.models.Ticker;

@Data
public class CompanyRequest {
    private String id;
    private String name;
    private Long turnover;
    private String ceo;
    private String boardOfDirs;
    private List<String> stockExchangeList;
    //    private String stockExList;
    private String sector;
    private String briefWriteup;
    //    private String tickList;
    private List<String> tickerList;
	public CompanyRequest(String id, String name, Long turnover, String ceo, String boardOfDirs,
			List<String> stockExchangeList, String sector, String briefWriteup, List<String> tickerList) {
		super();
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirs = boardOfDirs;
		this.stockExchangeList = stockExchangeList;
		this.sector = sector;
		this.briefWriteup = briefWriteup;
		this.tickerList = tickerList;
	}
	public CompanyRequest() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getBoardOfDirs() {
		return boardOfDirs;
	}
	public void setBoardOfDirs(String boardOfDirs) {
		this.boardOfDirs = boardOfDirs;
	}
	public List<String> getStockExchangeList() {
		return stockExchangeList;
	}
	public void setStockExchangeList(List<String> stockExchangeList) {
		this.stockExchangeList = stockExchangeList;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getBriefWriteup() {
		return briefWriteup;
	}
	public void setBriefWriteup(String briefWriteup) {
		this.briefWriteup = briefWriteup;
	}
	public List<String> getTickerList() {
		return tickerList;
	}
	public void setTickerList(List<String> tickerList) {
		this.tickerList = tickerList;
	}
    
    
}
