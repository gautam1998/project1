package com.StockMarketCharting.CompanyService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stockmarket.company.controller.CompanyController;
import com.stockmarket.company.dao.CompanyDao;
import com.stockmarket.company.exception.CompanyNotFoundException;
import com.stockmarket.company.model.Company;
import com.stockmarket.company.shared.CompanyResponse;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompanyControllerTest {

    @MockBean
    private CompanyDao companyRepository;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private CompanyController  companyController;
    
    @BeforeAll
    public void setUp() {
    	//Company company = new Company(1l,"Maruti","BSE","10000000","Dilip","Manoj","Automobile","Good Company","1Dff78");
    	Company company = new Company();
    	//CompanyDTO companyEntity = new CompanyDTO();
    	//BeanUtils.copyProperties(company, companyEntity);
    	companyRepository.saveAndFlush(company);
    }
    
    @Test
    public void canRetrieveByNameWhenExists() throws CompanyNotFoundException {
    	
        ResponseEntity<CompanyResponse> resp = companyController.findByCompanyName("Maruti");
        assertThat(resp.getStatusCode().equals(HttpStatus.FOUND));
    }

    @Test
    public void canCreateANewCompany() {
        // when
    	ResponseEntity<Company> companyResponse = restTemplate.postForEntity("/add/", new Company(), Company.class);

        // then
        assertThat(companyResponse.getStatusCode().equals(HttpStatus.CREATED));
    }

}

