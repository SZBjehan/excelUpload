package com.example.excelmsid.helper;


import com.example.excelmsid.entity.ExcelUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUploadHelper {

    //checking if the file is Excel or not
    public static boolean checkExcelFormat(MultipartFile file){

        String contentType = file.getContentType();

        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return  true;
        }

        else { return false ;}
    }


    // converts the excel to list
    public static List<ExcelUpload> convertExcelToListOfExcel(InputStream is){

        List<ExcelUpload> list = new ArrayList<>();
//        System.out.println(is);
//        try{
//
//            XSSFWorkbook workbook = new XSSFWorkbook(is);
//            XSSFSheet sheet = workbook.getSheet("sheet");
//
//            int rowNumber = 0;
//            Iterator<Row> iterator = sheet.iterator();
//
//            while (iterator.hasNext()){
//                Row row = iterator.next();
//
//                if (rowNumber == 0){
//                    rowNumber++;
//                    continue;
//                }
//
//                Iterator<Cell> cells = row.iterator();
//
//                int cid = 0;
//
//                ExcelUpload excelUpload = new ExcelUpload();
//
//                while(cells.hasNext()){
//                    Cell cell = cells.next();
//
//                    switch (cid){
//                        case 0:
//                            excelUpload.setID((long)cell.getNumericCellValue());
//                            break;
//                        case 1:
//                            excelUpload.setMSISDN((long)cell.getNumericCellValue());
//                            break;
//                        case 2:
//                            excelUpload.setPROD_ID((long)cell.getNumericCellValue());
//                            break;
//                        case 3:
//                            excelUpload.setPRODUCT_NAME(cell.getStringCellValue());
//                            break;
//                        case 4:
//                            excelUpload.setSTATUS(cell.getStringCellValue());
//                            break;
//                        default:
//                            break;
//
//                    }
//                    cid++;
//
//                }
//
//                list.add(excelUpload);
//            }
//
//
//        }
//
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet("ExcelUploads");
            Iterator<Row> rows = sheet.iterator();

            List<ExcelUpload> excelUploads = new ArrayList<ExcelUpload>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                ExcelUpload excelUpload = new ExcelUpload();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell cell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            excelUpload.setID((long)cell.getNumericCellValue());
                            break;
                        case 1:
                            excelUpload.setMSISDN((long)cell.getNumericCellValue());
                            break;
                        case 2:
                            excelUpload.setPROD_ID(cell.getStringCellValue());
                            break;
                        case 3:
                            excelUpload.setPRODUCT_NAME(cell.getStringCellValue());
                            break;
                        case 4:
                            excelUpload.setSTATUS(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                excelUploads.add(excelUpload);
            }

            workbook.close();

            return excelUploads;
        }

        catch (Exception e){
//            System.out.println("exception");
            e.printStackTrace();
        }
        System.out.println(list);
        return list;

    }



}
