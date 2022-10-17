package com.example.excelmsid.service;

import com.example.excelmsid.entity.ExcelUpload;
import com.example.excelmsid.helper.ExcelUploadHelper;
import com.example.excelmsid.repository.ExcelUploadRepository;
import org.hibernate.id.uuid.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ExcelUploadRepository excelUploadRepository;

    public void save(MultipartFile file){

        try {
            List<ExcelUpload> excelUploads = ExcelUploadHelper.convertExcelToListOfExcel(file.getInputStream());
            this.excelUploadRepository.saveAll(excelUploads);

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public List<ExcelUpload> getAllProducts(){
        return this.excelUploadRepository.findAll();
    }
}
