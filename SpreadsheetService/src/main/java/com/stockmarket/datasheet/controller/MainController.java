package com.stockmarket.datasheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stockmarket.datasheet.dto.ObjectDTO;
import com.stockmarket.datasheet.helper.ExcelHelper;
import com.stockmarket.datasheet.message.ResponseMessage;
import com.stockmarket.datasheet.model.Header;
import com.stockmarket.datasheet.service.ExcelService;
import com.stockmarket.datasheet.service.MainService;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/excel")
public class MainController {
    @Autowired
    MainService mainService;
    
    @Autowired
    ExcelService fileService;

    
    @GetMapping("/all")
	public String allAccess() {
	  System.out.println("hello1");
		return "Public Content.";
	}

    @PostMapping("/upload")
    public ResponseEntity<Header> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception {
        mainService.uploadExcel(file);
        List<ObjectDTO> stockPriceList = mainService.importExcelData2DB(file);
        return new ResponseEntity<>(mainService.getUploadSummary(stockPriceList), HttpStatus.OK);
    }
    
    @PostMapping("/upload2")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    	System.out.println("hello 1");
      String message = "";

      if (ExcelHelper.hasExcelFormat(file)) {
    	  System.out.println("hello 2");
        try {
        	System.out.println("hello 3");
          fileService.save(file);

          message = "Uploaded the file successfully: " + file.getOriginalFilename();
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
          message = "Could not upload the file: " + file.getOriginalFilename() + "!";
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
      }

      message = "Please upload an excel file!";
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

}
