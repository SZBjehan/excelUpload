package com.example.excelmsid.controller;

import com.example.excelmsid.entity.ExcelUpload;
import com.example.excelmsid.helper.ExcelUploadHelper;
import com.example.excelmsid.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin("*")
public class ExcelController {

    @Autowired
    private ExcelService excelService;


    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) {

        String message;

//        System.out.println(file);
        if (ExcelUploadHelper.checkExcelFormat(file)){

            this.excelService.save(file);
            message = "File is uploaded and saved to Database" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File format");
    }

    @GetMapping("/product")
    public List<ExcelUpload> getAllProduct(){
        return this.excelService.getAllProducts();
    }




}
