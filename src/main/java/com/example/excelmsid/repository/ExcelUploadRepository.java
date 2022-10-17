package com.example.excelmsid.repository;


import com.example.excelmsid.entity.ExcelUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelUploadRepository extends JpaRepository<ExcelUpload, Integer> {

}
